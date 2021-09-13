package com.entity;

import com.entity.empl.Employee;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Company {

    private String name;
    private List<Department> departmentList = new ArrayList<>();
    private Employee director;

    public Company(String name) {
        this.name = name;
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
}
