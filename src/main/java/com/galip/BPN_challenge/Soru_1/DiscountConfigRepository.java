package com.galip.BPN_challenge.Soru_1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DiscountConfigRepository extends JpaRepository<DiscountConfigEntity, Long> {
    Optional<DiscountConfigEntity> findByKeyValue(String keyValue);
}
