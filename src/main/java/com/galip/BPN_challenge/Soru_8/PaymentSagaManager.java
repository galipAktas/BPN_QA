package com.galip.BPN_challenge.Soru_8;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class PaymentSagaManager {

    private final AccountService accountService;
    private final TreasuryService treasuryService;
    private final LoanService loanService;

    public PaymentSagaManager(AccountService accountService, TreasuryService treasuryService, LoanService loanService) {
        this.accountService = accountService;
        this.treasuryService = treasuryService;
        this.loanService = loanService;
    }

    public void processPayment(String accountId, BigDecimal amount) {
        try {
            accountService.debitAccount(accountId, amount);
            treasuryService.registerIncoming(amount);
            loanService.creditLoan(accountId, amount);
        } catch (Exception e) {
            rollback(accountId, amount);
            throw new RuntimeException("Payment failed, rolling back transaction: " + e.getMessage());
        }
    }

    private void rollback(String accountId, BigDecimal amount) {
        // Birbirinden ayrı DB ya da microservisler için rollback, en sondan en başa doğru
        loanService.compensateCreditLoan(accountId, amount);
        treasuryService.compensateRegisterIncoming(amount);
        accountService.compensateDebitAccount(accountId, amount);
    }
}

