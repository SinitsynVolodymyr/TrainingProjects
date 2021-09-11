package com.entity;

import java.util.Date;

public final class Employee {

    final private String name;
    final private Date birthday;
    final private Date inputWorkDate;

    private Employee(String name, Date birthday, Date inputWork) {
        this.name = name;
        this.birthday = new Date(birthday.getTime());
        this.inputWorkDate = new Date(inputWork.getTime());
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return new Date(birthday.getTime());
    }

    public Date getInputWorkDate() {
        return new Date(inputWorkDate.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee temp = (Employee) o;
        return name.equals(temp.name) && birthday.equals(temp.birthday) && inputWorkDate.equals(temp.inputWorkDate);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return (name.hashCode()
                * simpleNumeric
                + birthday.hashCode())
                * simpleNumeric
                + inputWorkDate.hashCode();
    }
}
