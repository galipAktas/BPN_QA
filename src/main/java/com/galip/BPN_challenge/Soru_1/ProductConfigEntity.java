package com.galip.BPN_challenge.Soru_1;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_config")
public class ProductConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", unique = true, nullable = false)
    private String productName;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    public String getProductName() { return productName; }
    public BigDecimal getPrice() { return price; }
}

