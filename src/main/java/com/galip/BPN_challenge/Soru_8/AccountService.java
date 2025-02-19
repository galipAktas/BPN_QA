package com.galip.BPN_challenge.Soru_8;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountService {

    public void debitAccount(String accountId, BigDecimal amount) {
        System.out.println("Debiting account: " + accountId + " by " + amount);
        // DB1'e yazma işlemi burada yapılır
    }

    public void compensateDebitAccount(String accountId, BigDecimal amount) {
        System.out.println("Rolling back debit for account: " + accountId);
        // DB1'de yapılan işlem geri alınır
    }
}

