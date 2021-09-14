package com.entity.empl;

import com.exception.SalaryIsTooSmallException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OthersEmployee extends Employee{

    private String positionName;
    private String description = "";

    public OthersEmployee(String name, String positionName, Date birthday, Date inputWork) throws SalaryIsTooSmallException {
        super(name, birthday, inputWork);
        Objects.requireNonNull(positionName);
        this.positionName = positionName;
    }

    public OthersEmployee(String name, Date birthday, Date inputWork, BigDecimal salary, String positionName) throws SalaryIsTooSmallException {
        super(name, birthday, inputWork, salary);
        Objects.requireNonNull(positionName);
        this.positionName = positionName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o) || !(o instanceof OthersEmployee)) return false;
        OthersEmployee that = (OthersEmployee) o;
        return this.positionName.equals(that.positionName)&&this.description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return (positionName.hashCode()
                *simpleNumeric
                +description.hashCode())
                *simpleNumeric;
    }
}
