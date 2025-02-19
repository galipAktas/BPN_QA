package com.galip.BPN_challenge.Soru_5;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class TaxAndCommissionCalculator {

    private final TaxAndCommissionConfigService configService;

    public TaxAndCommissionCalculator(TaxAndCommissionConfigService configService) {
        this.configService = configService;
    }

    public BigDecimal calculateTax(BigDecimal amount, String country) {
        BigDecimal taxRate = configService.getTaxRate(country, amount);
        return amount.multiply(taxRate);
    }

    public BigDecimal calculateCommission(BigDecimal transactionAmount, String productType) {
        BigDecimal commissionRate = configService.getCommissionRate(productType);
        return transactionAmount.multiply(commissionRate);
    }
}

