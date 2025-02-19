package com.galip.BPN_challenge.Soru_1;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class DiscountConfigService {

    private final DiscountConfigRepository discountConfigRepository;

    public DiscountConfigService(DiscountConfigRepository discountConfigRepository) {
        this.discountConfigRepository = discountConfigRepository;
    }

    public BigDecimal getDiscount(String customerEmail, BigDecimal basePrice) {
        // Eğer müşteri kurumsal e-posta kullanıyorsa, yüzdelik indirim uygula
        Optional<DiscountConfigEntity> corporateDiscount = discountConfigRepository.findByKeyValue("@corporate.com");
        if (customerEmail.endsWith("@corporate.com")) {
            return corporateDiscount.map(DiscountConfigEntity::getDiscountValue).orElse(BigDecimal.ONE);
        }

        // Eğer sipariş tutarı belirli eşikleri geçiyorsa, sabit indirim uygula
        Optional<DiscountConfigEntity> bulkDiscount10000 = discountConfigRepository.findByKeyValue("10000");
        Optional<DiscountConfigEntity> bulkDiscount5000 = discountConfigRepository.findByKeyValue("5000");

        if (basePrice.compareTo(new BigDecimal("10000")) > 0) {
            return basePrice.subtract(bulkDiscount10000.map(DiscountConfigEntity::getDiscountValue).orElse(BigDecimal.ZERO));
        } else if (basePrice.compareTo(new BigDecimal("5000")) > 0) {
            return basePrice.subtract(bulkDiscount5000.map(DiscountConfigEntity::getDiscountValue).orElse(BigDecimal.ZERO));
        }

        return basePrice; // Eğer hiçbir indirim kriterine uymuyorsa fiyatı değiştirme
    }
}

