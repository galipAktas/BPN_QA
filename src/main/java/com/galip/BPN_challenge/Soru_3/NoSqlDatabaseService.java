package com.galip.BPN_challenge.Soru_3;

import org.springframework.stereotype.Service;

@Service
public class NoSqlDatabaseService implements DatabaseService {

    @Override
    public void connect() {
        System.out.println("NoSQL Database connected.");
    }

    @Override
    public void insertInvoice(Invoice invoice) {
        System.out.println("Invoice inserted into NoSQL Database: " + invoice);
    }

    @Override
    public void disconnect() {
        System.out.println("NoSQL Database disconnected.");
    }
}

