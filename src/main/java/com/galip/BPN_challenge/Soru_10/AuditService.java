package com.galip.BPN_challenge.Soru_10;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public void logTransaction(GeneralLedgerEntry entry) {
        // örnek bir metod, normalde bu kayıtlar bir DB'ye kaydedilir.
        System.out.println("Audit Log: Posting to ledger: " + entry);
    }
}

