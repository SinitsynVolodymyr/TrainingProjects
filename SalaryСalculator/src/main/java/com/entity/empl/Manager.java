package com.entity.empl;

import com.exception.SalaryIsTooSmallException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee{

    private List<Employee> employeeList = new ArrayList<>();

    public Manager(String name, Date birthday, Date inputWork) throws SalaryIsTooSmallException {
        super(name, birthday, inputWork);
    }

    public Manager(String name, Date birthday, Date inputWork, BigDecimal salary) throws SalaryIsTooSmallException {
        super(name, birthday, inputWork, salary);
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) || !(o instanceof Manager)) return false;
        Manager that = (Manager) o;
        return this.employeeList.equals(that.employeeList);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return employeeList.hashCode() * simpleNumeric;
    }

}
