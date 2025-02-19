package com.galip.BPN_challenge.Soru_10;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountingRuleService {

    public void applyIFRSRules(GeneralLedgerEntry entry) {
        if (entry.isUnderIFRS()) {
            if (entry.getAccountType().equals("EQUITY") && entry.getDebit().compareTo(BigDecimal.valueOf(10000)) > 0) {
                throw new IllegalStateException("Equity hesapları IFRS limit aşımı!");
            }
        }
    }
}

