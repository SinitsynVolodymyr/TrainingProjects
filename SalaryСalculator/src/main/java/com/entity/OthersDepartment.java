package com.entity;

import com.entity.empl.OthersEmployee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OthersDepartment extends Department<OthersEmployee> {

    private List<OthersEmployee> employeeList = new ArrayList<>();

    public OthersDepartment(String name) {
        super(name);
    }

    @Override
    public void addEmployee(OthersEmployee employee) {
        employeeList.add(employee);
    }

    @Override
    public List<OthersEmployee> getEmployeeList() {
        return employeeList;
    }

}
