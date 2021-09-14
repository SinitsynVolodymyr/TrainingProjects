package com.entity;

import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.model.Model;
import com.model.PayForOnePerson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ManagerDepartment extends Department<Employee>{

    private Manager manager;

    public ManagerDepartment(String name, Manager manager) {
        super(name);
        Objects.requireNonNull(manager);
        this.manager = manager;
    }

    public void addEmployee(Employee employee){
        manager.addEmployee(employee);
    }

    public List<Employee> getEmployeeList() {
        return manager.getEmployeeList();
    }

    public Manager getManager() {
        return manager;
    }

    public BigDecimal getRate(){
        BigDecimal result = new BigDecimal("0");
        result = result.add(manager.getSalary());
        for (Employee employeeTmp: manager.getEmployeeList()){
            result = result.add(employeeTmp.getSalary());
        }
        return result;
    }

    @Override
    public List<PayForOnePerson> calculateSalary() {
        List<PayForOnePerson> personList = new ArrayList<>();
        BigDecimal amount = this.getFund().getAmount();

        if (this.getFund().getType().equals(SalariesFund.FundType.BALANCED)){
            personList.addAll(calculateBalancedSalary());
        }else if (this.getFund().getType().equals(SalariesFund.FundType.UNBALANCED)){
            personList.addAll(calculateUnbalancedSalary());
        }

        return personList;
    }

    private PayForOnePerson initPayAccount(Employee employee, BigDecimal empPremium){
        PayForOnePerson result = new PayForOnePerson(employee,
                empPremium.add(employee.getSalary()));
        result.setDepartment(this);
        result.setPremium(empPremium);
        return result;
    }

    private List<PayForOnePerson> calculateBalancedSalary(){
        List<PayForOnePerson> result = new ArrayList<>();
        BigDecimal empPremium = calculateBalancedPremiumValue();
        result.add(initPayAccount(this.getManager(),empPremium));
        for (Employee employee: this.getEmployeeList()){
            result.add(initPayAccount(employee,empPremium));
        }
        return result;
    }

    private BigDecimal calculateBalancedPremiumValue(){
        BigDecimal amount = this.getFund().getAmount();
        int amountParts = this.getEmployeeList().size()+1;
        BigDecimal premium = amount.divide(new BigDecimal(amountParts), Model.mc);
        return premium;
    }

    private List<PayForOnePerson> calculateUnbalancedSalary(){
        List<PayForOnePerson> result = new ArrayList<>();

        Manager manager = this.getManager();
        BigDecimal manPremium = calculateUnbalancedPremiumValueForEmployee(manager);
        result.add(initPayAccount(this.getManager(),manPremium));

        for (Employee employee: this.getEmployeeList()){
            BigDecimal empPremium = calculateUnbalancedPremiumValueForEmployee(employee);
            result.add(initPayAccount(employee,empPremium));
        }
        return result;
    }

    private BigDecimal calculateUnbalancedPremiumValueForEmployee(Employee employee){
        BigDecimal manPart = employee.getSalary().divide(this.getRate(),Model.mc);
        BigDecimal premium = manPart.multiply(this.getFund().getAmount());
        return premium;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerDepartment that = (ManagerDepartment) o;
        return name.equals(that.name)
                && manager.equals(that.manager)
                && fund.equals(that.fund);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return ((name.hashCode()
                * simpleNumeric
                + manager.hashCode())
                * simpleNumeric
                + fund.hashCode())
                * simpleNumeric;
    }
}
