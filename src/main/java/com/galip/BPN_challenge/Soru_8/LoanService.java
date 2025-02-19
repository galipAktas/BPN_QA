package com.galip.BPN_challenge.Soru_8;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class LoanService {

    public void creditLoan(String accountId, BigDecimal amount) {
        System.out.println("Crediting loan for account: " + accountId + " by " + amount);
        // DB2'ye yazma işlemi
    }

    public void compensateCreditLoan(String accountId, BigDecimal amount) {
        System.out.println("Rolling back credit loan for account: " + accountId);
        // DB2'deki kredi işlemini geri al
    }
}

