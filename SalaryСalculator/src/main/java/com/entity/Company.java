package com.entity;

import com.entity.empl.Employee;

import java.util.*;

@Deprecated
public class Company {

    private String name;
    private List<Department> departmentList = new ArrayList<>();
    private Employee director;
    private SalariesFund fund;
    private boolean isOnlyCompanyFund;

    public Company(String name, SalariesFund fund) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(fund);
        this.name = name;
        this.fund = fund;
    }

    public boolean isOnlyCompanyFund() {
        return isOnlyCompanyFund;
    }

    public void setOnlyCompanyFund(boolean companyFund) {
        isOnlyCompanyFund = companyFund;
    }

    public String getName() {
        return name;
    }

    public void addDepartment(Department dep){
        departmentList.add(dep);
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(departmentList, company.departmentList) && Objects.equals(director, company.director) && Objects.equals(fund, company.fund);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return ((name.hashCode()
                * simpleNumeric
                + director.hashCode())
                * simpleNumeric
                + fund.hashCode())
                * simpleNumeric;
    }
}
