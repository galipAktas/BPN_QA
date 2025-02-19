package com.galip.BPN_challenge.Soru_7;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentProcessing {

    private final List<PaymentHandler> handlers;

    public PaymentProcessing(List<PaymentHandler> handlers) {
        this.handlers = handlers;
    }

    public void processCreditCardPayment(String cardNumber, String expiration, BigDecimal amount) {
        PaymentContext context = new PaymentContext(cardNumber, expiration, amount, handlers);
        context.next();
    }
}

