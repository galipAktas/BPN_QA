package com.galip.BPN_challenge.Soru_2;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "shipping_cost_config")
public class ShippingCostConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "weight_threshold", nullable = false)
    private int weightThreshold;

    @Column(name = "is_fragile", nullable = false)
    private boolean isFragile;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;

    public String getRegion() { return region; }
    public int getWeightThreshold() { return weightThreshold; }
    public boolean isFragile() { return isFragile; }
    public BigDecimal getCost() { return cost; }
}

