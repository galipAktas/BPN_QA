package com.galip.BPN_challenge.Soru_9;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeEventProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    public TradeEventProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(Order order) {
        // Aynı orderId'ye sahip mesajlar aynı partition’a giderek sıralı işlenecek
        kafkaTemplate.send("trade-orders", order.getOrderId(), order);
    }
}

