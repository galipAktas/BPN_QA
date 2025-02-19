package com.galip.BPN_challenge.Soru_7;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Order(2)
public class PaymentGatewayHandler implements PaymentHandler {

    @Override
    public void handle(PaymentContext context) {
        boolean success = callPaymentGateway(context.getCardNumber(), context.getExpiration(), context.getAmount());
        if (!success) {
            throw new RuntimeException("Payment failed!");
        }
        context.next();
    }

    private boolean callPaymentGateway(String cardNumber, String expiration, BigDecimal amount) {
        // Burada gerçek bir ödeme API’si çağrılabilir
        return true; // Simüle edilen başarı durumu
    }
}

