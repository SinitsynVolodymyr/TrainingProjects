package com.entity;

import com.entity.empl.Employee;

import java.util.ArrayList;
import java.util.List;


public class Department {

    private String name;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String name) {
        this.name = name;
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
        return name.equals(that.name) && employeeList.equals(that.employeeList);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return (name.hashCode()
                * simpleNumeric
                + employeeList.hashCode());
    }
}
