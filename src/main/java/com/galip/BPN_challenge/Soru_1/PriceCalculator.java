package com.galip.BPN_challenge.Soru_1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class PriceCalculator {

    private final ProductConfigService productConfigService;
    private final DiscountConfigService discountConfigService;
    private final TaxConfigService taxConfigService;

    public PriceCalculator(ProductConfigService productConfigService,
                           DiscountConfigService discountConfigService,
                           TaxConfigService taxConfigService) {
        this.productConfigService = productConfigService;
        this.discountConfigService = discountConfigService;
        this.taxConfigService = taxConfigService;
    }

    // Servisler ile veri tabanından sabit değerler çekilerek alınıyor
    public BigDecimal calculatePrice(Order order) {
        BigDecimal basePrice = calculateBasePrice(order);
        basePrice = applyDiscount(order, basePrice);
        basePrice = applyTax(order, basePrice);
        return basePrice;
    }

    // Private metodlar ile her bir işlem ayrı ayrı metodlarda yapılıyor
    // İç içe if ve for yapıları yerine stream API kullandım
    private BigDecimal calculateBasePrice(Order order) {
        return Optional.ofNullable(order.getProducts()) // null check ekledim
                .orElse(List.of())
                .stream()
                .map(productConfigService::getProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal applyDiscount(Order order, BigDecimal basePrice) {
        return discountConfigService.getDiscount(order.getCustomerEmail(), basePrice);
    }

    private BigDecimal applyTax(Order order, BigDecimal basePrice) {
        return basePrice.add(basePrice.multiply(taxConfigService.getTaxRate(order.getShippingAddress())));
    }
}

