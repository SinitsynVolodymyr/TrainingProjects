package com.entity;

import com.entity.empl.Employee;
import com.entity.empl.Manager;

import java.util.List;
import java.util.Objects;


public class Department {

    private String name;
    private Manager manager;
    private SalariesFund fund;

    public Department(String name, SalariesFund fund, Manager manager) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(fund);
        Objects.requireNonNull(manager);
        this.name = name;
        this.fund = fund;
        this.manager = manager;
    }

    public void addEmployee(Employee employee){
        manager.addEmployee(employee);
    }

    public List<Employee> getEmployeeList() {
        return manager.getEmployeeList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
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
