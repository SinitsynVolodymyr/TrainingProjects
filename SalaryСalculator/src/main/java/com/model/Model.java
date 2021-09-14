package com.model;

import com.entity.Company;
import com.entity.Department;
import com.entity.SalariesFund;
import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;
import com.view.View;

import javax.print.attribute.standard.PresentationDirection;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Model {

    private List<OthersEmployee> others = new ArrayList<>();
    private List<Department> departmentList = new ArrayList<>();
    private SalariesFund fund;
    private SalariesFund.FundType fundTypeForOthers = SalariesFund.FundType.BALANCED;
    private MathContext mc = new MathContext(2, RoundingMode.FLOOR);

    public Model(List<OthersEmployee> others, List<Department> departmentList) {
        Objects.requireNonNull(others);
        Objects.requireNonNull(departmentList);
        this.others = others;
        this.departmentList = departmentList;
    }

    public Payroll calculatePayroll(Date date){
        int calcMonth = date.getMonth();
        Payroll result = new Payroll();
        BigDecimal minFund = this.getMinFund();
        BigDecimal remainder = fund.getAmount().subtract(minFund);
        BigDecimal othersSalary = new BigDecimal("0");

        if (fund.getType().equals(SalariesFund.FundType.BALANCED)){
            int amountParts = departmentList.size()+1;
            BigDecimal departmentSalary = remainder.divide(new BigDecimal(amountParts),mc);
            for (Department department: departmentList){
                department.getFund().setAmount(departmentSalary);
            }
            othersSalary = departmentSalary;
        }else if (fund.getType().equals(SalariesFund.FundType.UNBALANCED)){
            BigDecimal sum = new BigDecimal("0");
            for (Department department: departmentList){
                BigDecimal minSalaryDep = department.getSalary();
                BigDecimal depPart = minSalaryDep.divide(minFund,mc);
                BigDecimal depSalary = depPart.multiply(remainder);
                department.getFund().setAmount(depSalary);
                sum = sum.add(depSalary);
            }
            othersSalary = remainder.subtract(sum);
        }

        for (Department depTmp: departmentList){
            result.personList.addAll(calcDepartment(depTmp));
        }
        result.personList.addAll(calcOthers(others,othersSalary,fundTypeForOthers));

        return result;
    }

    private List<PayForOnePerson> calcOthers(List<OthersEmployee> othersEmployee
            , BigDecimal salary
            , SalariesFund.FundType type){
        List<PayForOnePerson> personList = new ArrayList<>();

        if (type.equals(SalariesFund.FundType.BALANCED)){
            int amountParts = othersEmployee.size();
            BigDecimal employeeSalary = salary.divide(new BigDecimal(amountParts),mc);
            for (Employee employee: othersEmployee){
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, employeeSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(View.othersName);
                payForOnePerson.setPremium(employeeSalary);
                personList.add(payForOnePerson);
            }
        }else if (type.equals(SalariesFund.FundType.UNBALANCED)){
            BigDecimal minSalaryDep = new BigDecimal("0");
            for (Employee employee: othersEmployee){
                minSalaryDep = minSalaryDep.add(employee.getSalary());
            }
            for (Employee employee: othersEmployee){
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,mc);
                BigDecimal empSalary = empPart.multiply(salary);
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(View.othersName);
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
    }

    private List<PayForOnePerson> calcDepartment(Department department){
        List<PayForOnePerson> personList = new ArrayList<>();
        BigDecimal amount = department.getFund().getAmount();

        if (department.getFund().getType().equals(SalariesFund.FundType.BALANCED)){
                int amountParts = department.getEmployeeList().size()+1;
                BigDecimal employeeSalary = amount.divide(new BigDecimal(amountParts),mc);
                PayForOnePerson payForOneManager = new PayForOnePerson(department.getManager(),
                        employeeSalary.add(department.getManager().getSalary()));
                payForOneManager.setDepartmentName(department.getName());
                payForOneManager.setPremium(employeeSalary);
                personList.add(payForOneManager);
                for (Employee employee: department.getEmployeeList()){
                    PayForOnePerson payForOnePerson = new PayForOnePerson(employee, employeeSalary.add(employee.getSalary()));
                    payForOnePerson.setDepartmentName(department.getName());
                    payForOnePerson.setPremium(employeeSalary);
                    personList.add(payForOnePerson);
                }
            }else if (department.getFund().getType().equals(SalariesFund.FundType.UNBALANCED)){
                BigDecimal minSalaryDep = department.getSalary();

                BigDecimal manPart = department.getManager().getSalary().divide(minSalaryDep,mc);
                BigDecimal manSalary = manPart.multiply(amount);
                PayForOnePerson payForOneManager = new PayForOnePerson(department.getManager(),
                        manSalary.add(department.getManager().getSalary()));
                payForOneManager.setDepartmentName(department.getName());
                payForOneManager.setPremium(manSalary);
                personList.add(payForOneManager);

                for (Employee employee: department.getEmployeeList()){
                    BigDecimal empPart = employee.getSalary().divide(minSalaryDep,mc);
                    BigDecimal empSalary = empPart.multiply(amount);
                    PayForOnePerson payForOnePerson = new PayForOnePerson(employee, empSalary.add(employee.getSalary()));
                    payForOnePerson.setDepartmentName(department.getName());
                    payForOnePerson.setPremium(empSalary);
                    personList.add(payForOnePerson);
                }
        }

        return personList;
    }


    public SalariesFund.FundType getFundTypeForOthers() {
        return fundTypeForOthers;
    }

    public void setFundTypeForOthers(SalariesFund.FundType fundTypeForOthers) {
        this.fundTypeForOthers = fundTypeForOthers;
    }

    public void addOthersEmployee(OthersEmployee other){
        Objects.requireNonNull(other);
        others.add(other);
    }

    public void addDepartment(Department department){
        Objects.requireNonNull(department);
        departmentList.add(department);
    }

    public BigDecimal getMinFund(){
        BigDecimal result = new BigDecimal("0");
        for (Department depTmp: departmentList){
            for (Employee empTmp: depTmp.getEmployeeList()){
                result = result.add(empTmp.getSalary());
            }
        }

        for (OthersEmployee otherTmp: others){
            result = result.add(otherTmp.getSalary());
        }

        return result;
    }


    public List<OthersEmployee> getOthers() {
        return others;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public SalariesFund getFund() {
        return fund;
    }

    public void setFund(SalariesFund fund) {
        Objects.requireNonNull(fund);
        this.fund = fund;
    }
}
