package com.example.demo.services;

import com.example.demo.models.Card;
import com.example.demo.models.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void createTransaction(Transaction transaction) {
        this.transactionRepository.createTransaction(transaction);
    }

    public boolean authorizeTransaction(Integer id, Card card) {
        return this.transactionRepository.authorizeTransaction(id, card);
    }

    public boolean captureTransaction(Integer id) {
        return this.transactionRepository.captureTransaction(id);
    }

    public void updateTransaction(Transaction transaction, Integer id) {
        this.transactionRepository.updateTransaction(transaction, id);
    }

    public Transaction getTransaction(Integer index) {
        return this.transactionRepository.getTransaction(index);
    }

    public void deleteTransaction(Integer index) {
        this.transactionRepository.deleteTransaction(index);
    }
}
