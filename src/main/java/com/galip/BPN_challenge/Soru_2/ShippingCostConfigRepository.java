package com.galip.BPN_challenge.Soru_2;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShippingCostConfigRepository extends JpaRepository<ShippingCostConfigEntity, Long> {
    Optional<ShippingCostConfigEntity> findByRegionAndWeightThresholdAndIsFragile(String region, int weightThreshold, boolean isFragile);
}

