package com.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {

    private String name;
    private Set<Employee> employeeList = new HashSet<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return name.equals(that.name) && Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return (name.hashCode()
                * simpleNumeric
                + employeeList.hashCode());
    }
}
