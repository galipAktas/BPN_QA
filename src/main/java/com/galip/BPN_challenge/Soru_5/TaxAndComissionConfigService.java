package com.galip.BPN_challenge.Soru_5;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class TaxAndCommissionConfigService {

    @Value("#{${tax.rates}}")
    private Map<String, BigDecimal> taxRates;

    @Value("#{${commission.rates}}")
    private Map<String, BigDecimal> commissionRates;

    @Value("${tax.rates.HIGH_AMOUNT_THRESHOLD}")
    private BigDecimal highAmountThreshold;

    public BigDecimal getTaxRate(String country, BigDecimal amount) {
        BigDecimal taxRate = taxRates.get(country);
        if (taxRate == null) {
            throw new RuntimeException("Tax rate not found for country: " + country);
        }
        return (amount.compareTo(highAmountThreshold) > 0) ? taxRate.add(BigDecimal.valueOf(0.05)) : taxRate;
    }

    public BigDecimal getCommissionRate(String productType) {
        BigDecimal commissionRate = commissionRates.get(productType);
        if (commissionRate == null) {
            throw new RuntimeException("Commission rate not found for product type: " + productType);
        }
        return commissionRate;
    }
}

