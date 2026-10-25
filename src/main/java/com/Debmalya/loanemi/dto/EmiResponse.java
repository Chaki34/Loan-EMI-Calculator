package com.Debmalya.loanemi.dto;




import java.math.BigDecimal;

public class EmiResponse {

    private BigDecimal monthlyEmi;
    private BigDecimal totalPayment;
    private BigDecimal totalInterest;

    public EmiResponse(BigDecimal monthlyEmi,
                       BigDecimal totalPayment,
                       BigDecimal totalInterest) {
        this.monthlyEmi = monthlyEmi;
        this.totalPayment = totalPayment;
        this.totalInterest = totalInterest;
    }

    public BigDecimal getMonthlyEmi() {
        return monthlyEmi;
    }

    public BigDecimal getTotalPayment() {
        return totalPayment;
    }

    public BigDecimal getTotalInterest() {
        return totalInterest;
    }
}