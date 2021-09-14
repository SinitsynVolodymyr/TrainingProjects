package com.entity;

import com.entity.empl.Employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public abstract class Department<T extends Employee> {

    protected String name;
    protected SalariesFund fund;

    public Department(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public abstract void addEmployee(T employee);

    public abstract List<T> getEmployeeList();

    public String getName() {
        return name;
    }


    public SalariesFund getFund() {
        return fund;
    }

    public void setFund(SalariesFund fund) {
        Objects.requireNonNull(fund);
        this.fund = fund;
    }

    public abstract BigDecimal getRate();


}
