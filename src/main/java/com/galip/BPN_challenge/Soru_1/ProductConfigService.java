package com.galip.BPN_challenge.Soru_1;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ProductConfigService {

    private final ProductConfigRepository productConfigRepository;

    public ProductConfigService(ProductConfigRepository productConfigRepository) {
        this.productConfigRepository = productConfigRepository;
    }

    public BigDecimal getProductPrice(String productName) {
        return productConfigRepository.findByProductName(productName)
                .map(ProductConfigEntity::getPrice)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));
    }
}

