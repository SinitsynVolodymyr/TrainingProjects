package com.entity;

import java.math.BigDecimal;

public class SalariesFund {

    BigDecimal amount;
    FundType type;

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
        BALANCED,UNBALANCED;
    }


}
