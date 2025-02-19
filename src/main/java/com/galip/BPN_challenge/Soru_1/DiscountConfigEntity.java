package com.galip.BPN_challenge.Soru_1;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "discount_config")
public class DiscountConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "discount_type", nullable = false)
    private String discountType;

    @Column(name = "key_value", nullable = false)
    private String keyValue;

    @Column(name = "discount_value", nullable = false)
    private BigDecimal discountValue;

    public String getDiscountType() { return discountType; }
    public String getKeyValue() { return keyValue; }
    public BigDecimal getDiscountValue() { return discountValue; }
}

