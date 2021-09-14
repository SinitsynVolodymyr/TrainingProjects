package com.model;

import com.entity.ManagerDepartment;
import com.entity.OthersDepartment;
import com.entity.SalariesFund;
import com.entity.empl.Employee;
import com.entity.empl.OthersEmployee;
import com.view.View;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Model {

    private OthersDepartment others;
    private List<ManagerDepartment> departmentList = new ArrayList<>();
    private SalariesFund fund;
    private SalariesFund.FundType fundTypeForOthers = SalariesFund.FundType.BALANCED;
    private MathContext mc = new MathContext(20, RoundingMode.FLOOR);

    public Model(OthersDepartment others, List<ManagerDepartment> departmentList) {
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
            for (ManagerDepartment department: departmentList){
                department.getFund().setAmount(departmentSalary);
            }
            othersSalary = departmentSalary;
        }else if (fund.getType().equals(SalariesFund.FundType.UNBALANCED)){
            BigDecimal sum = new BigDecimal("0");
            for (ManagerDepartment department: departmentList){
                BigDecimal minSalaryDep = department.getRate();
                BigDecimal depPart = minSalaryDep.divide(minFund,mc);
                BigDecimal depSalary = depPart.multiply(remainder);
                department.getFund().setAmount(depSalary);
                sum = sum.add(depSalary);
            }
            othersSalary = remainder.subtract(sum);
        }

        for (ManagerDepartment depTmp: departmentList){
            result.personList.addAll(calcDepartment(depTmp));
        }
        result.personList.addAll(calcOthers(others.getEmployeeList(),othersSalary,fundTypeForOthers));

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
                BigDecimal empPart = employee.getSalary().divide(minSalaryDep,mc); BigDecimal empSalary = empPart.multiply(salary);
                PayForOnePerson payForOnePerson = new PayForOnePerson(employee, empSalary.add(employee.getSalary()));
                payForOnePerson.setDepartmentName(View.othersName);
                payForOnePerson.setPremium(empSalary);
                personList.add(payForOnePerson);
            }
        }

        return personList;
    }

    private List<PayForOnePerson> calcDepartment(ManagerDepartment department){
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
                BigDecimal minSalaryDep = department.getRate();

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
        others.addEmployee(other);
    }

    public void addDepartment(ManagerDepartment department){
        Objects.requireNonNull(department);
        departmentList.add(department);
    }

    public BigDecimal getMinFund(){
        BigDecimal result = new BigDecimal("0");
        for (ManagerDepartment depTmp: departmentList){
            result = result.add(depTmp.getManager().getSalary());
            for (Employee empTmp: depTmp.getEmployeeList()){
                result = result.add(empTmp.getSalary());
            }
        }

        for (OthersEmployee otherTmp: others.getEmployeeList()){
            result = result.add(otherTmp.getSalary());
        }

        return result;
    }

    public OthersDepartment getOthers() {
        return others;
    }

    public List<ManagerDepartment> getDepartmentList() {
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
