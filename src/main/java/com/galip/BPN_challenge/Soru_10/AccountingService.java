package com.galip.BPN_challenge.Soru_10;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountingService {

    private final AccountingValidationService validationService;
    private final AccountingRuleService ruleService;
    private final AuditService auditService;

    public AccountingService(AccountingValidationService validationService,
                             AccountingRuleService ruleService,
                             AuditService auditService) {
        this.validationService = validationService;
        this.ruleService = ruleService;
        this.auditService = auditService;
    }

    @Transactional
    public void postGeneralLedgerEntry(GeneralLedgerEntry entry) {
        validationService.validateEntry(entry); // Validation işlemi
        ruleService.applyIFRSRules(entry); // İş mantığı kontrolü
        auditService.logTransaction(entry); // Audit kaydı
    }
}

