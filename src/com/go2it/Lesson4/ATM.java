package com.go2it.Lesson4;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private float currentSumInATM;
    private int numberOfATM;
    private int yearOfInstallation;


    public ATM(float currentSumInATM, int numberOfATM, int yearOfInstallation) {
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        this.yearOfInstallation = yearOfInstallation;
        quantityOfATM++;
      //  addATMToArray(ATMNetwork, ? )
    }

    public ATM(float currentSumInATM, int numberOfATM) { //overloaded constructor
        this.currentSumInATM = currentSumInATM;
        this.numberOfATM = numberOfATM;
        quantityOfATM++;
      //  addATMToArray(ATMNetwork, ? )
    }

    private static int quantityOfATM = 0;
    private static int numberOfWithdrawsFromAllATM = 0;
    private static int numberOfDepositsToAllATM = 0;
    ArrayList<ATM> ATMNetwork = new ArrayList<>();

    static Scanner in = new Scanner(System.in);


    public void operateWithATM(CreditCard card) {  // check if pin is correct
        String pin;
            if (CreditCard.cNumber.equals(card.getCardNumber())) {
                System.out.println("Please enter your pin");
                pin = in.nextLine();
                if (CreditCard.cPin.equals(pin)) {
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

        byte choice;
        System.out.println("Please select an option: \nEnter 1 to withdraw \nEnter 2 to deposit " +
                "\nEnter 3 to check the balance");
        choice = in.nextByte();

        switch (choice) {
            case 1:
                float sumToWithdraw;
                System.out.println("Please enter amount to withdraw");
                sumToWithdraw = in.nextFloat();
                if (currentSumInATM > sumToWithdraw && card.getCardBalance() > -1000) {
                    currentSumInATM -= sumToWithdraw;
                    card.setCardBalance(sumToWithdraw);
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
                card.setCardBalance(-(sumToDeposit));
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

    public static ArrayList<ATM> addATMToArray (ArrayList<ATM> arr, ATM atm){ //create an Arraylist of ATM
        for (int i = 0; i< quantityOfATM; i++){
            arr.add(atm);
        }
        return arr;
    }

    public static void main(String[] args) {
        ATM atm1 = new ATM(15000, 4564, 2020);
        ATM atm2 = new ATM(20000, 2212);

        CreditCard card1 = new CreditCard("1111222233334444", 500);
        CreditCard card2 = new CreditCard("1111222233335555", 1000);

        atm1.operateWithATM(card1);

        System.out.println("Number of withdraws from all ATM is " + numberOfWithdrawsFromAllATM);
        System.out.println("Number of deposit from all ATM is " + numberOfDepositsToAllATM);

    }
}
