package com.model;

import com.entity.Company;
import com.entity.empl.Employee;
import com.entity.empl.Manager;
import com.entity.empl.OthersEmployee;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<OthersEmployee> others = new ArrayList<>();
    private List<Manager> managerList = new ArrayList<>();

    public Model(List<OthersEmployee> others, List<Manager> managerList) {
        this.others = others;
        this.managerList = managerList;
    }
}
