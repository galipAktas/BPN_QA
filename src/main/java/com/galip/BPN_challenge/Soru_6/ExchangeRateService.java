package com.galip.BPN_challenge.Soru_6;

import java.math.BigDecimal;

public interface ExchangeRateService {
    BigDecimal getRate(String from, String to);
}

