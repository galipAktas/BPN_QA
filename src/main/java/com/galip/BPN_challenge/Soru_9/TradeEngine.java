package com.galip.BPN_challenge.Soru_9;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TradeEngine {

    private final OrderRepository orderRepository;

    public TradeEngine(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void matchOrders(Order incomingOrder) {
        for (Order existing : orderRepository.findOpenOrders()) {
            if (existing.isMatch(incomingOrder)) {
                executeTrade(existing, incomingOrder);
                existing.setStatus(OrderStatus.FILLED);
                incomingOrder.setStatus(OrderStatus.FILLED);
                orderRepository.save(existing);
                orderRepository.save(incomingOrder);
                break;
            }
        }
    }

    private void executeTrade(Order existing, Order incoming) {
        BigDecimal price = existing.getPrice();
        BigDecimal total = price.multiply(BigDecimal.valueOf(existing.getQuantity()));

        // Trade işlemleri burada kaydedilebilir
        System.out.println("Trade executed: " + existing.getId() + " with " + incoming.getId());
    }
}
