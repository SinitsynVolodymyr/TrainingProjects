package com.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class SalariesFund {

    private BigDecimal amount;
    private FundType type;

    public SalariesFund(FundType type) {
        this(new BigDecimal("0"),type);
    }

    public SalariesFund(BigDecimal amount, FundType type) {
        this.amount = amount;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public FundType getType() {
        return type;
    }


    public enum FundType {
        BALANCED("Balanced"),UNBALANCED("Unbalanced");

        private final String name;

        FundType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalariesFund fund = (SalariesFund) o;
        return amount.equals(fund.amount) && type == fund.type;
    }

    @Override
    public int hashCode() {
        int simpleNumeric = 31;
        return (amount.hashCode()
                * simpleNumeric
                + type.hashCode())
                * simpleNumeric;
    }
}
