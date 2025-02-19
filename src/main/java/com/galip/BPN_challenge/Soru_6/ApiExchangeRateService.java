package com.galip.BPN_challenge.Soru_6;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class ApiExchangeRateService implements ExchangeRateService {

    @Override
    public BigDecimal getRate(String from, String to) {
        // Gerçek bir API çağrısı yapılabilir (Ör. Open Exchange Rates API)
        return BigDecimal.valueOf(1.10); // Simüle edilen API cevabı
    }
}

