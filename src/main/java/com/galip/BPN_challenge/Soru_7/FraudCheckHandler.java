package com.galip.BPN_challenge.Soru_7;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Order(1)
public class FraudCheckHandler implements PaymentHandler {

    @Override
    public void handle(PaymentContext context) {
        if (context.getAmount().compareTo(BigDecimal.valueOf(5000)) > 0) {
            throw new RuntimeException("Fraud suspected!");
        }
        context.next();
    }
}
