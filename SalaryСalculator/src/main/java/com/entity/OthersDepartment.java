package com.entity;

import com.entity.empl.Manager;
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

    @Override
    public BigDecimal getRate() {
        BigDecimal result = new BigDecimal("0");
        for (OthersEmployee empTmp : employeeList) {
            result = result.add(empTmp.getSalary());
        }
        return result;
    }


}
