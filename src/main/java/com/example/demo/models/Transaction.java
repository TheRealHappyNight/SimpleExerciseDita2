package com.example.demo.models;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Transaction {
    private static final AtomicInteger currTransactionId = new AtomicInteger(1);
    private final int transactionId;
    private final LocalDate transactionDate;
    private Status status;
    private final int amount;
    private LocalDate refundDate;
    private LocalDate captureDate;
    private final Card card;
    private final User user;

    public Transaction(int amount, Card card, User user) {
        this.transactionId = currTransactionId.getAndIncrement();
        this.transactionDate = LocalDate.now();
        this.amount = amount;
        this.card = new Card(card);
        this.user = new User(user);
    }

    public Transaction(Transaction transaction) {
        this.transactionId = transaction.transactionId;
        this.transactionDate = transaction.transactionDate;
        this.status = transaction.status;
        this.amount = transaction.amount;
        this.refundDate = transaction.refundDate;
        this.captureDate = transaction.captureDate;
        this.card = new Card(transaction.card);
        this.user = new User(transaction.user);
    }

    public void setStatus(Status status) {
        switch(status) {
            case CANCELLED:
            case REFUNDED: {
                this.refundDate = LocalDate.now();
                break;
            }
            case CAPTURED: {
                this.captureDate = LocalDate.now();
                break;
            }
        }
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public int getAmount() {
        return amount;
    }

    public Card getCard() {
        return card;
    }

    public User getUser() {
        return user;
    }

    public enum Status {
        INITIATED,
        AUTHORIZED,
        CAPTURED,
        REFUNDED,
        CANCELLED
    }
}
