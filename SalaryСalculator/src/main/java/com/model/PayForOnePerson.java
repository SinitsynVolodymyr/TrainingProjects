package com.model;

import com.entity.Department;
import com.entity.empl.Employee;

import java.math.BigDecimal;

public class PayForOnePerson {

    private Employee employee;
    private Department department;
    private BigDecimal salary;
    private BigDecimal premium;
    private BigDecimal premiumBirthday;

    public PayForOnePerson(Employee employee, BigDecimal salary) {
        this.employee = employee;
        this.salary = salary.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getPremiumBirthday() {
        return premiumBirthday;
    }

    public void setPremiumBirthday(BigDecimal premiumBirthday) {
        this.premiumBirthday = premiumBirthday;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getPremium() {
        return premium;
    }

    public void setPremium(BigDecimal premium) {
        this.premium = premium.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
