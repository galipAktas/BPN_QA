package com.galip.BPN_challenge.Soru_7;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Order(3)
public class AccountingHandler implements PaymentHandler {

    @Override
    public void handle(PaymentContext context) {
        System.out.println("Transaction recorded for " + context.getCardNumber() + ": " + context.getAmount());
        context.next();
    }
}

