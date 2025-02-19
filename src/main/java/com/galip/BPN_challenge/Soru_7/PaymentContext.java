package com.galip.BPN_challenge.Soru_7;

import java.math.BigDecimal;
import java.util.List;

public class PaymentContext {
    private final String cardNumber;
    private final String expiration;
    private final BigDecimal amount;
    private final List<PaymentHandler> handlers;
    private int currentHandlerIndex = 0;

    public PaymentContext(String cardNumber, String expiration, BigDecimal amount, List<PaymentHandler> handlers) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.amount = amount;
        this.handlers = handlers;
    }

    public void next() {
        if (currentHandlerIndex < handlers.size()) {
            handlers.get(currentHandlerIndex++).handle(this);
        }
    }

    public String getCardNumber() { return cardNumber; }
    public String getExpiration() { return expiration; }
    public BigDecimal getAmount() { return amount; }
}

