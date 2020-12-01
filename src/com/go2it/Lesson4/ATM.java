package com.go2it.Lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private int currentSumInATM;
    private int numberOfATM;
    private int dataOfInstallation;

    //See it in this way: ATM is created on the factory (constructor).
//Then staff installs it on the spot and loads money (another method).
// Otherwise, ATM would be transported with money inside already :)
    public ATM(int currentSumInATM, int numberOfATM, int dataOfInstallation) {
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        this.dataOfInstallation = dataOfInstallation;
        quantityOfATM++;
    }

    public ATM(int currentSumInATM, int numberOfATM) { //overloaded constructor
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        quantityOfATM++;
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

    public int getDataOfInstallation() {
        return dataOfInstallation;
    }

    public void setDataOfInstallation(int dataOfInstallation) {
        this.dataOfInstallation = dataOfInstallation;
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

    private static int quantityOfATM = 0;
    private static int numberOfWithdrawsFromAllATM = 0;
    private static int numberOfDepositsToAllATM = 0;

    //    List instead of ArrayList --> best practice.
    static ArrayList<ATM> ATMNetwork = new ArrayList<>();


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

    public static ArrayList<ATM> addATMToArray(ArrayList<ATM> arr, ATM atm) { //create an Arraylist of ATM
        arr.add(atm);
        return arr;
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM(15000, 4564, 2020);
        atm1.setCurrentSumInATM(5000);
        ATM atm2 = new ATM(20000, 2212);

        CreditCard card1 = new CreditCard("1111222233334444", 500);
        CreditCard card2 = new CreditCard("1111222233335555", 1000);

        atm1.operateWithATM(card1);

        System.out.println("Number of withdraws from all ATM is " + numberOfWithdrawsFromAllATM);
        System.out.println("Number of deposit from all ATM is " + numberOfDepositsToAllATM);

        for (ATM arr : ATMNetwork) {
            System.out.println(arr);

        }
    }
}
