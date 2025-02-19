package com.galip.BPN_challenge.Soru_1;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tax_config")
public class TaxConfigEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", unique = true, nullable = false)
    private String city;

    @Column(name = "tax_rate", nullable = false)
    private BigDecimal taxRate;

    public String getCity() { return city; }
    public BigDecimal getTaxRate() { return taxRate; }
}

