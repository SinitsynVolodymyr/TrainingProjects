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
            int amountParts = this.getEmployeeList().size()+1;
            BigDecimal employeeSalary = amount.divide(new BigDecimal(amountParts), Model.mc);
            PayForOnePerson payForOneManager = new PayForOnePerson(this.getManager(),
                    employeeSalary.add(this.getManager().getSalary()));
            payForOneManager.setDepartment(this);
            payForOneManager.setPremium(employeeSalary);
            personList.add(payForOneManager);
            for (Employee employee: this.getEmployeeList()){
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, employeeSalary.add(employee.getSalary()));
                payForOnePerson.setDepartment(this);
                payForOnePerson.setPremium(employeeSalary);
                personList.add(payForOnePerson);
            }
        }else if (this.getFund().getType().equals(SalariesFund.FundType.UNBALANCED)){
            BigDecimal minSalaryDep = this.getRate();

            BigDecimal manPart = this.getManager().getSalary().divide(minSalaryDep,Model.mc);
            BigDecimal manSalary = manPart.multiply(amount);
            PayForOnePerson payForOneManager = new PayForOnePerson(this.getManager(),
                    manSalary.add(this.getManager().getSalary()));
            payForOneManager.setDepartment(this);
            payForOneManager.setPremium(manSalary);
            personList.add(payForOneManager);

            for (Employee employee: this.getEmployeeList()){
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,Model.mc);
                BigDecimal empSalary = empPart.multiply(amount);
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartment(this);
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
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
