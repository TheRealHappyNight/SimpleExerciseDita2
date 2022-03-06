package com.example.demo.repository;

import com.example.demo.models.Card;
import com.example.demo.models.Transaction;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TransactionRepository {
    Map<Integer, Transaction> idTransactionMap = new HashMap<>();

    public void createTransaction(Transaction transaction) {
        this.idTransactionMap.put(transaction.getTransactionId(), transaction);
    }

    public boolean authorizeTransaction(Integer id, Card card) {
        if (!this.idTransactionMap.containsKey(id)) {
//            throw new IllegalArgumentException("Index doesn't have a associated transaction");
            return false;
        }
        var transaction = this.idTransactionMap.get(id);
        if (transaction.getStatus() != Transaction.Status.INITIATED) {
//            throw new IllegalArgumentException("Transaction is not initiated");
            return false;
        }

        transaction.authorize(card);
        return true;
    }

    public boolean captureTransaction(Integer id) {
        if (!this.idTransactionMap.containsKey(id)) {
            return false;
        }
        var transaction = this.idTransactionMap.get(id);
        if (transaction.getStatus() != Transaction.Status.AUTHORIZED) {
            return false;
        }

        transaction.setStatus(Transaction.Status.CAPTURED);
        return true;
    }

    public void updateTransaction(Transaction transaction, Integer id) {
        if (!this.idTransactionMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.idTransactionMap.put(id, transaction);
    }

    public Transaction getTransaction(int index) {
        if (!this.idTransactionMap.containsKey(index)) {
            throw new IllegalArgumentException();
        }

        return this.idTransactionMap.get(index);
    }

    public void deleteTransaction(int index) {
        if (!this.idTransactionMap.containsKey(index)) {
            throw new IllegalArgumentException();
        }

        this.idTransactionMap.remove(index);
    }
}
