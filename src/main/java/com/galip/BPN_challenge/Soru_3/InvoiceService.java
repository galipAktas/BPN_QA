package com.galip.BPN_challenge.Soru_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final DatabaseService databaseService;

    @Autowired
    public InvoiceService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void createInvoice(Invoice invoice) {
        databaseService.connect();
        databaseService.insertInvoice(invoice);
        databaseService.disconnect();
    }
}

