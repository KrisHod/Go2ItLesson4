package com.go2it.Lesson4;

import java.util.ArrayList;

public class CreditCard {
    private static final String cNumber = "1111222233334444";
    private static final String cPin = "1234";

    public static String getcNumber() {
        return cNumber;
    }

    public static String getcPin() {
        return cPin;
    }

    private String cardNumber;
    private float cardBalance;

    public CreditCard(String cardNumber, float cardBalance) {
        this.cardNumber = cardNumber;
        this.cardBalance = cardBalance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(float cardBalance) {
        this.cardBalance = cardBalance;
    }

    public float setCardBalanceAfterWithdraw(float sum) throws IllegalArgumentException {
        if ((cardBalance -= sum) < 0) {
            throw new IllegalArgumentException("Not enough money in the account to process this transaction");
        } else {
            cardBalance -= sum;
            return cardBalance;
        }
    }

    public float setCardBalanceAfterDeposit(float sum) {
        cardBalance += sum;
        return cardBalance;
    }
}
