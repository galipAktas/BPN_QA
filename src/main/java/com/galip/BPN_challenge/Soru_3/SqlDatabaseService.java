package com.galip.BPN_challenge.Soru_3;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SqlDatabaseService implements DatabaseService {

    @Override
    public void connect() {
        System.out.println("SQL Database connected.");
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        System.out.println("Invoice inserted into SQL Database: " + invoice);
    }

    @Override
    public void disconnect() {
        System.out.println("SQL Database disconnected.");
    }
}

