package com.galip.BPN_challenge.Soru_1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TaxConfigRepository extends JpaRepository<TaxConfigEntity, Long> {
    Optional<TaxConfigEntity> findByCity(String city);
}