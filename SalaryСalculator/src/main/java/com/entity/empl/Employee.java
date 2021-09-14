package com.entity.empl;

import com.Config;
import com.exception.SalaryIsTooSmallException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Employee {

    protected String name;
    protected Date birthday;
    protected Date inputWorkDate;
    protected BigDecimal salary;

    public Employee(String name, Date birthday, Date inputWork) throws SalaryIsTooSmallException {

        this(name, birthday, inputWork, Config.MIN_SALARY);
    }

    public Employee(String name, Date birthday, Date inputWork, BigDecimal salary) throws SalaryIsTooSmallException {

        Objects.requireNonNull(name);
        Objects.requireNonNull(birthday);
        Objects.requireNonNull(inputWork);
        Objects.requireNonNull(salary);
        this.name = name;
        this.birthday = new Date(birthday.getTime());
        this.inputWorkDate = new Date(inputWork.getTime());
        setSalary(salary);
    }

    public void setSalary(BigDecimal salary) throws SalaryIsTooSmallException {
        Objects.requireNonNull(salary);
        checkSalary(salary);
        this.salary = salary;
    }

    public BigDecimal getRate() {
        return salary;
    }

    public BigDecimal getMinSalary(Date date) {
        if (isBirthdayInMonth(date))
            return salary.add(Config.BIRTHDAY_PREMIUM);
        else
            return salary;
    }

    public boolean isBirthdayInMonth(Date date){
        if (date.getMonth()==getBirthday().getMonth()) return true;
        else return false;
    }

    public static void checkSalary(BigDecimal salary) throws SalaryIsTooSmallException {
        if (salary.compareTo(Config.MIN_SALARY)<0){
            throw new SalaryIsTooSmallException(salary, Config.MIN_SALARY);
        }
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
        if (o == null || !(o instanceof Employee)) return false;
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
