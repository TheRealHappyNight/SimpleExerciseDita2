package com.example.demo.controllers;

import com.example.demo.models.Card;
import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    private final TransactionService transactionService;

    public TransactionsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void createTransaction(@RequestBody Transaction transaction) {
        this.transactionService.createTransaction(transaction);
    }

    //TODO:: Cardul vine fara date
    @PutMapping("/{id}/authorized")
    public ResponseEntity<Object> authorizeTransaction(@PathVariable String id, @RequestBody Card card) {
        if (!this.transactionService.authorizeTransaction(Integer.valueOf(id), card)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/captured")
    public ResponseEntity<Object> captureTransaction(@PathVariable String id) {
        if (!this.transactionService.captureTransaction(Integer.valueOf(id))) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void updateTransaction(@RequestBody Transaction transaction, @PathVariable String id) {
        this.transactionService.updateTransaction(transaction, Integer.valueOf(id));
    }

    @GetMapping(value = "/{id}")
    public Transaction getTransaction(@PathVariable String id) {
        return this.transactionService.getTransaction(Integer.valueOf(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTransaction(@PathVariable String id) {
        this.transactionService.deleteTransaction(Integer.valueOf(id));
    }
}
