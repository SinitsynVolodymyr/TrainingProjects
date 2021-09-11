package com.entity;

import java.util.Date;

public final class Employee {

    final private String name;
    final private Date birthday;
    final private Date inputWork;

    private Employee(String name, Date birthday, Date inputWork) {
        this.name = name;
        this.birthday = new Date(birthday.getTime());
        this.inputWork = new Date(inputWork.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return new Date(birthday.getTime());
    }

    public Date getInputWork() {
        return new Date(inputWork.getTime());
    }
}
