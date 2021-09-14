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
    private List<ManagerDepartment> departmentList;
    private SalariesFund fund;
    public static final MathContext mc = new MathContext(20, RoundingMode.FLOOR);

    public Model(OthersDepartment others, List<ManagerDepartment> departmentList) {
        Objects.requireNonNull(others);
        Objects.requireNonNull(departmentList);
        this.others = others;
        this.departmentList = departmentList;
    }

    public Payroll calculatePayroll(Date date){
        Payroll result = new Payroll();

        if (fund.getType().equals(SalariesFund.FundType.BALANCED))
            calcBalancedDepartFund();
        else if (fund.getType().equals(SalariesFund.FundType.UNBALANCED))
            calcUnbalancedDepartFund();

        result.personList.addAll(others.calculateSalary(date));
        for (ManagerDepartment depTmp: departmentList){
            result.personList.addAll(depTmp.calculateSalary(date));
        }

        return result;
    }

    private void calcBalancedDepartFund(){
        BigDecimal remainder = fund.getAmount().subtract(this.getAllRate());
        int amountParts = departmentList.size()+1;
        BigDecimal departmentSalary = remainder.divide(new BigDecimal(amountParts),mc);
        for (ManagerDepartment department: departmentList){
            department.getFund().setAmount(departmentSalary);
        }
        others.getFund().setAmount(departmentSalary);
    }

    private void calcUnbalancedDepartFund(){
        BigDecimal minFund = this.getAllRate();
        BigDecimal remainder = fund.getAmount().subtract(minFund);
        BigDecimal sum = new BigDecimal("0");
        for (ManagerDepartment department: departmentList){
            BigDecimal minSalaryDep = department.getRate();
            BigDecimal depPart = minSalaryDep.divide(minFund,mc);
            BigDecimal depSalary = depPart.multiply(remainder);
            department.getFund().setAmount(depSalary);
            sum = sum.add(depSalary);
        }
        others.getFund().setAmount(remainder.subtract(sum));
    }

    public void addOthersEmployee(OthersEmployee other){
        Objects.requireNonNull(other);
        others.addEmployee(other);
    }

    public void addDepartment(ManagerDepartment department){
        Objects.requireNonNull(department);
        departmentList.add(department);
    }

    public BigDecimal getAllRate(){
        BigDecimal result = new BigDecimal("0");
        for (ManagerDepartment depTmp: departmentList){
            result = result.add(depTmp.getRate());
        }
        result = result.add(others.getRate());

        return result;
    }
    public BigDecimal getMinSalary(Date date){
        BigDecimal result = new BigDecimal("0");
        for (ManagerDepartment depTmp: departmentList){
            result = result.add(depTmp.getMinSalary(date));
        }
        result = result.add(others.getMinSalary(date));

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
