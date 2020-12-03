package com.go2it.Lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATM {
    private int currentSumInATM;
    private int numberOfATM;
    private int currentSoftwareVersion;

    private static int quantityOfATM = 0;
    private static int numberOfWithdrawsFromAllATM = 0;
    private static int numberOfDepositsToAllATM = 0;
    private static int theNewestSoftwareVersion;
    private static int previousSoftwareVersion;

    static List<Integer> ATMNetwork = new ArrayList<>();

    public ATM(int currentSumInATM, int numberOfATM, int currentSoftwareVersion) {
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        this.currentSoftwareVersion = currentSoftwareVersion;
        quantityOfATM++;
        ATMNetwork.add(numberOfATM);
    }

    public ATM(int currentSumInATM, int numberOfATM) { //overloaded constructor
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        quantityOfATM++;
        ATMNetwork.add(numberOfATM);
    }

    public int getCurrentSumInATM() {
        return currentSumInATM;
    }

    public void setCurrentSumInATM(int currentSumInATM) {
        this.currentSumInATM = currentSumInATM;
    }

    public int getNumberOfATM() {
        return numberOfATM;
    }

    public void setNumberOfATM(int numberOfATM) {
        this.numberOfATM = numberOfATM;
    }

    public static int getQuantityOfATM() {
        return quantityOfATM;
    }

    public static void setQuantityOfATM(int quantityOfATM) {
        ATM.quantityOfATM = quantityOfATM;
    }

    public static int getNumberOfWithdrawsFromAllATM() {
        return numberOfWithdrawsFromAllATM;
    }

    public static void setNumberOfWithdrawsFromAllATM(int numberOfWithdrawsFromAllATM) {
        ATM.numberOfWithdrawsFromAllATM = numberOfWithdrawsFromAllATM;
    }

    public static int getNumberOfDepositsToAllATM() {
        return numberOfDepositsToAllATM;
    }

    public static void setNumberOfDepositsToAllATM(int numberOfDepositsToAllATM) {
        ATM.numberOfDepositsToAllATM = numberOfDepositsToAllATM;
    }

    public int getCurrentSoftwareVersion() {
        return currentSoftwareVersion;
    }

    public int setCurrentSoftwareVersion(int currentVersion) {
        this.currentSoftwareVersion = currentVersion;
        return currentVersion;
    }

    public static int getTheNewestSoftwareVersion() {
        return theNewestSoftwareVersion;
    }

    public static void setTheNewestSoftwareVersion(int theNewestSoftwareVersion) {
        ATM.theNewestSoftwareVersion = theNewestSoftwareVersion;
    }

    public static int getPreviousSoftwareVersion() {
        return previousSoftwareVersion;
    }

    public static void setPreviousSoftwareVersion(int previousSoftwareVersion) {
        ATM.previousSoftwareVersion = previousSoftwareVersion;
    }

    public static List<Integer> getATMNetwork() {
        return ATMNetwork;
    }

    public static void setATMNetwork(List<Integer> ATMNetwork) {
        ATM.ATMNetwork = ATMNetwork;
    }


    public void operateWithATM(CreditCard card) { // check if pin is correct
        Scanner in = new Scanner(System.in);
        String pin;
        if (CreditCard.getcNumber().equals(card.getCardNumber())) {
            System.out.println("Please enter your pin");
            pin = in.nextLine();
            if (CreditCard.getcPin().equals(pin)) {
                transaction(card);
            } else {
                System.out.println("Invalid pin. Please try again");
                operateWithATM(card);
            }
        } else {
            System.out.println("Unknown card. Contact the bank");
        }
    }


    public void transaction(CreditCard card) {  // we give the choice of the desired transaction
        Scanner in = new Scanner(System.in);
        byte choice;
        System.out.println("Please select an option: \nEnter 1 to withdraw \nEnter 2 to deposit " +
                "\nEnter 3 to check the balance");
        choice = in.nextByte();

        switch (choice) {
            case 1:
                float sumToWithdraw;
                System.out.println("Please enter amount to withdraw");
                sumToWithdraw = in.nextFloat();
                if (currentSumInATM > sumToWithdraw && card.getCardBalance() > sumToWithdraw) {
                    currentSumInATM -= sumToWithdraw;
                    card.setCardBalanceAfterWithdraw(sumToWithdraw);
                    numberOfWithdrawsFromAllATM++;
                    System.out.println("You have withdrawn " + sumToWithdraw + ". Your current balance is " + card.getCardBalance());
                    anotherTransaction(card);
                } else {
                    System.out.println("Operation is impossible");
                }
                break;
            case 2:
                float sumToDeposit;
                System.out.println("Please enter amount to deposit");
                sumToDeposit = in.nextFloat();
                currentSumInATM += sumToDeposit;
                card.setCardBalanceAfterDeposit(sumToDeposit);
                numberOfDepositsToAllATM++;
                System.out.println("You have deposited " + sumToDeposit + ". Your current balance is " + card.getCardBalance());
                anotherTransaction(card);
                break;
            case 3:
                System.out.println("Your balance is " + card.getCardBalance());
                anotherTransaction(card);
                break;
            default:
                System.out.println("Invalid option.");
                anotherTransaction(card);
                break;
        }
    }

    public void anotherTransaction(CreditCard card) {  // continue to operate with ATM
        Scanner in = new Scanner(System.in);
        byte choice;
        System.out.println("Do you want another transaction? \nPress 1 to continue \nPress 2 to exit");
        choice = in.nextByte();
        if (choice == 1) {
            transaction(card);
        } else if (choice == 2) {
            System.out.println("Thanks for choosing us. Good bye!");
        } else {
            System.out.println("Invalid choice");
            anotherTransaction(card);
        }
    }
}
