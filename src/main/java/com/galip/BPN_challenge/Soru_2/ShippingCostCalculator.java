package com.galip.BPN_challenge.Soru_2;

import java.math.BigDecimal;

public class ShippingCostCalculator {

    private final ShippingCostConfigService shippingCostConfigService;

    public ShippingCostCalculator(ShippingCostConfigService shippingCostConfigService) {
        this.shippingCostConfigService = shippingCostConfigService;
    }

    public BigDecimal calculateShippingCost(int weight, String shippingRegion, boolean isFragile) {
        return shippingCostConfigService.getShippingCost(shippingRegion, weight, isFragile);
    }
}
