package com.galip.BPN_challenge.Soru_2;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ShippingCostConfigService {

    private final ShippingCostConfigRepository shippingCostConfigRepository;

    public ShippingCostConfigService(ShippingCostConfigRepository shippingCostConfigRepository) {
        this.shippingCostConfigRepository = shippingCostConfigRepository;
    }

    public BigDecimal getShippingCost(String region, int weight, boolean isFragile) {
        int weightThreshold = (weight < 5) ? 5 : 10000;
        return shippingCostConfigRepository.findByRegionAndWeightThresholdAndIsFragile(region, weightThreshold, isFragile)
                .map(ShippingCostConfigEntity::getCost)
                .orElseThrow(() -> new RuntimeException("Shipping cost not found for given parameters"));
    }
}

