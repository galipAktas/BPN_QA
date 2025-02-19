package com.galip.BPN_challenge.Soru_1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductConfigRepository extends JpaRepository<ProductConfigEntity, Long> {
    Optional<ProductConfigEntity> findByProductName(String productName);
}
