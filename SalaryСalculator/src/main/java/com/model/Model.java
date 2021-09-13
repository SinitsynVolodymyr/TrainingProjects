package com.model;

import com.entity.Company;

public class Model {

    private Company company;

    public Model(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

}
