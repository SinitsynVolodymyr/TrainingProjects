package com.entity;

import com.entity.empl.Employee;
import com.entity.empl.OthersEmployee;
import com.model.Model;
import com.model.PayForOnePerson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OthersDepartment extends Department<OthersEmployee> {

    private List<OthersEmployee> employeeList = new ArrayList<>();

    public OthersDepartment(String name) {
        super(name);
    }

    @Override
    public void addEmployee(OthersEmployee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<OthersEmployee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public BigDecimal getRate() {
        BigDecimal result = new BigDecimal("0");
        for (OthersEmployee empTmp : employeeList) {
            result = result.add(empTmp.getSalary());
        }
        return result;
    }

    @Override
    public List<PayForOnePerson> calculateSalary() {
        List<PayForOnePerson> personList = new ArrayList<>();

        if (this.fund.getType().equals(SalariesFund.FundType.BALANCED)){
            int amountParts = this.getEmployeeList().size();
            BigDecimal employeeSalary = this.fund.getAmount().divide(new BigDecimal(amountParts), Model.mc);
            for (Employee employee: this.getEmployeeList()){
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, employeeSalary.add(employee.getSalary()));
                payForOnePerson.setDepartment(this);
                payForOnePerson.setPremium(employeeSalary);
                personList.add(payForOnePerson);
            }
        }else if (this.fund.getType().equals(SalariesFund.FundType.UNBALANCED)){
            BigDecimal minSalaryDep = new BigDecimal("0");
            for (Employee employee: this.getEmployeeList()){
                minSalaryDep = minSalaryDep.add(employee.getSalary());
            }
            for (Employee employee: this.getEmployeeList()){
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,Model.mc); BigDecimal empSalary = empPart.multiply(this.fund.getAmount());
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartment(this);
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
    }


}
