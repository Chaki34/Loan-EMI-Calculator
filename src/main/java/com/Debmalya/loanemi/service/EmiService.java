package com.Debmalya.loanemi.service;




import com.Debmalya.loanemi.dto.EmiRequest;
import com.Debmalya.loanemi.dto.EmiResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class EmiService {

    public EmiResponse calculateEmi(EmiRequest request) {

        double principal = request.getPrincipal();
        double annualRate = request.getAnnualInterestRate();
        int months = request.getTenureMonths();

        double monthlyRate = annualRate / 12.0 / 100.0;
        double emi;

        if (monthlyRate == 0) {
            emi = principal / months;
        } else {
            double factor = Math.pow(1 + monthlyRate, months);

            emi = principal * monthlyRate * factor
                    / (factor - 1);
        }

        double totalPayment = emi * months;
        double totalInterest = totalPayment - principal;

        return new EmiResponse(
                money(emi),
                money(totalPayment),
                money(totalInterest)
        );
    }

    private BigDecimal money(double amount) {
        return BigDecimal.valueOf(amount)
                .setScale(2, RoundingMode.HALF_UP);
    }
}