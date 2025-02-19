package com.galip.BPN_challenge.Soru_3;

public interface DatabaseService {
    void connect();
    void insertInvoice(Invoice invoice);
    void disconnect();
}

