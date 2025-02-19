package com.galip.BPN_challenge.Soru_10;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountingValidationService {

    public void validateEntry(GeneralLedgerEntry entry) {
        if (entry.getDebit().compareTo(BigDecimal.ZERO) < 0 || entry.getCredit().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amounts cannot be negative");
        }

        if (!entry.getAccountType().matches("ASSET|LIABILITY|EQUITY")) {
            throw new IllegalArgumentException("Invalid account type");
        }
    }
}

