package com.entity;

import com.entity.empl.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Department {

    private String name;
    private List<Employee> employeeList = new ArrayList<>();
    private SalariesFund fund;

    public Department(String name, SalariesFund fund) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(fund);
        this.name = name;
        this.fund = fund;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name)
                && employeeList.equals(that.employeeList)
                && fund.equals(that.fund);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return ((name.hashCode()
                * simpleNumeric
                + employeeList.hashCode())
                * simpleNumeric
                + fund.hashCode())
                * simpleNumeric;
    }
}
