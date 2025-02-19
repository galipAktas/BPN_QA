package com.galip.BPN_challenge.Soru_1;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TaxConfigService {

    private final TaxConfigRepository taxConfigRepository;

    public TaxConfigService(TaxConfigRepository taxConfigRepository) {
        this.taxConfigRepository = taxConfigRepository;
    }

    public BigDecimal getTaxRate(String city) {
        return taxConfigRepository.findByCity(city)
                .map(TaxConfigEntity::getTaxRate)
                .orElse(new BigDecimal("0.08")); // Varsayılan vergi oranı
    }
}

