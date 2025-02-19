package com.galip.BPN_challenge.Soru_8;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TreasuryService {

    public void registerIncoming(BigDecimal amount) {
        System.out.println("Registering incoming payment: " + amount);
        // Harici mikroservise çağrı yapar
    }

    public void compensateRegisterIncoming(BigDecimal amount) {
        System.out.println("Rolling back treasury record for amount: " + amount);
        // Hazine kaydını geri al
    }
}

