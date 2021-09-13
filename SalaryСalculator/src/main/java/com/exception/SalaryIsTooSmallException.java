package com.exception;

import java.math.BigDecimal;

public class SalaryIsTooSmallException extends Exception {

    private final BigDecimal salary;
    private final BigDecimal minSalary;

    public SalaryIsTooSmallException(BigDecimal salary, BigDecimal minSalary) {
        this.salary = new BigDecimal(salary.toString());
        this.minSalary = new BigDecimal(salary.toString());
    }

    public BigDecimal getSalary() {
        return new BigDecimal(salary.toString());
    }

    @Override
    public String getMessage() {
        return "The input salary ("+salary.toString()+") is less than the minimum ("+minSalary.toString()+").";
    }
}
