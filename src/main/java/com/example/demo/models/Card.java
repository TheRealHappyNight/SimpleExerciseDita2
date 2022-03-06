package com.example.demo.models;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Card {
    public static final int CARD_NUMBER_LENGTH = 13;
    private static final AtomicInteger currentCardNumber = new AtomicInteger(1);
    private final int cardId;
    private final String cardNumber;
    private final String cardHolderName;
    private final LocalDate expiryDate;
    private final String cvc;

    public Card(String cardHolderName) {
        this.cardId = currentCardNumber.get();
        this.cardNumber = createCardNumber();
        this.cardHolderName = cardHolderName;
        this.expiryDate = LocalDate.now().plusYears(4);
        this.cvc = String.valueOf(new Random().nextInt(900) + 100);
    }

    public Card(Card card) {
        this.cardId = card.cardId;
        this.cardNumber = card.cardNumber;
        this.cardHolderName = card.cardHolderName;
        this.expiryDate = card.expiryDate;
        this.cvc = card.cvc;
    }

    private String createCardNumber() {
        String currNumber = String.valueOf(currentCardNumber.getAndIncrement());
        int remainingNumbers = CARD_NUMBER_LENGTH - currNumber.length();
        StringBuilder cnp = new StringBuilder();
        while(remainingNumbers-- > 1) {
            cnp.append(0);
        }
        return cnp.append(currNumber).toString();
    }

    public int getCardId() {
        return cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCvc() {
        return cvc;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", cvc='" + cvc + '\'' +
                '}';
    }
}
