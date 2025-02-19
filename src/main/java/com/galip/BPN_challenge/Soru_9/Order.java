package com.galip.BPN_challenge.Soru_9;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private BigDecimal price;
    private int quantity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public boolean isMatch(Order incomingOrder) {
        return this.price.equals(incomingOrder.getPrice()) && this.status == OrderStatus.OPEN;
    }

    // Getter ve Setter metotları...
}

