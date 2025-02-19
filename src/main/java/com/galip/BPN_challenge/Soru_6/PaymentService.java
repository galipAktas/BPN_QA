package com.galip.BPN_challenge.Soru_6;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class PaymentService {

    private final ExchangeRateService exchangeRateService;

    public PaymentService(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    public BigDecimal convertCurrency(BigDecimal amount, String from, String to) {
        if (from.equals(to)) {
            return amount;
        }

        BigDecimal rate = exchangeRateService.getRate(from, to);
        return amount.multiply(rate);
    }
}

