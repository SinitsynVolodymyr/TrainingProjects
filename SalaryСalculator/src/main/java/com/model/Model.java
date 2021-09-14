package com.model;

import com.entity.Company;
import com.entity.Department;
import com.entity.SalariesFund;
import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {

    private List<OthersEmployee> others = new ArrayList<>();
    private List<Department> departmentList = new ArrayList<>();
    private SalariesFund fund;
    private SalariesFund.FundType fundTypeForOthers = SalariesFund.FundType.BALANCED;

    public Model(List<OthersEmployee> others, List<Department> departmentList) {
        Objects.requireNonNull(others);
        Objects.requireNonNull(departmentList);
        this.others = others;
        this.departmentList = departmentList;
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
