package com.galip.BPN_challenge.Soru_9;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TradeEventConsumer {

    private final TradeEngine tradeEngine;
    private final OrderRepository orderRepository;

    public TradeEventConsumer(TradeEngine tradeEngine, OrderRepository orderRepository) {
        this.tradeEngine = tradeEngine;
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "trade-orders", groupId = "trade-group")
    @Transactional
    public void consumeTrade(Order order) {
        try {
            // Pessimistic Locking ile order kilitlenerek işleniyor
            Order lockedOrder = orderRepository.findByIdWithLock(order.getId())
                    .orElseThrow(() -> new RuntimeException("Order not found!"));

            tradeEngine.matchOrders(lockedOrder);
        } catch (Exception e) {
            System.err.println("Trade processing failed: " + e.getMessage());
        }
    }
}

