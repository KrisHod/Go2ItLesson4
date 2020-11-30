package com.go2it.Lesson4;

import java.util.ArrayList;

public class CreditCard {
    public static final String cNumber = "1111222233334444";
    public static final String cPin = "1234";

//    private static final String cNumber2 = "1111 2222 3333 5555";
//    private static final String cPin2 = "5678";

//    private static ArrayList<String> cardNumbers = new ArrayList<>();
//
//    public static ArrayList<String> setCardNumbers(ArrayList<String> cardNumbers) {
//        CreditCard.cardNumbers.add(cNumber1);
//        CreditCard.cardNumbers.add(cNumber2);
//        return cardNumbers;
//    }
//
//    private static ArrayList<String> cardPins = new ArrayList<>();
//
//    public ArrayList<String> createArrayListOfCardNumbers(String cNumber) {
//        cardNumbers.add(cNumber1);
//        cardNumbers.add(cNumber2);
//        return cardNumbers;
//    }
//
//    public ArrayList<String> createArrayListOfCardPins(String cPin) {
//        cardPins.add(cPin1);
//        cardPins.add(cPin2);
//        return cardPins;
//    }
//
//    public static ArrayList<String> getCardNumbers() {
//        return cardNumbers;
//    }
//
//    public static ArrayList<String> getCardPins() {
//        return cardPins;
//    }

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

    public float setCardBalance(float sum) {
        return cardBalance -= sum;
    }
}
