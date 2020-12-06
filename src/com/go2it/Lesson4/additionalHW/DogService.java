package com.go2it.Lesson4.additionalHW;

import java.util.ArrayList;
import java.util.Scanner;

public class DogService {
    private static ArrayList<Dog> listOfAllDogs = new ArrayList<>();
    private static ArrayList<Dog> listOfHomelessDogs = new ArrayList<>();

    public static ArrayList<Dog> getListOfAllDog() {
        return listOfAllDogs;
    }

    public void setListOfAllDog(ArrayList<Dog> listOfAllDog) {
        this.listOfAllDogs = listOfAllDog;
    }

    public static ArrayList<Dog> getListOfHomelessDogs() {
        return listOfHomelessDogs;
    }

    public static void setListOfHomelessDogs(ArrayList<Dog> listOfHomelessDogs) {
        DogService.listOfHomelessDogs = listOfHomelessDogs;
    }

    public static void chooseMenuOptions() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select an option: \nEnter 1 to add a dog \nEnter 2 to view all dogs " +
                "\nEnter 3 to view all available dogs \nEnter 4 to view the dog by Id " +
                "\nEnter 5 to update dog home status \nEnter 6 to exit");
        byte choice = input.nextByte();
        if (choice > 0 && choice < 7) {
            switch (choice) {
                case 1:
                    addDogToList();
                    System.out.println("You added a dog with id " + getListOfAllDog().size() + " to the system");
                    chooseAnotherOption();
                    break;
                case 2:
                    viewAllDogs();
                    chooseAnotherOption();
                    break;
                case 3:
                    viewAllAvailableDogs();
                    chooseAnotherOption();
                    break;
                case 4:
                    viewDogById();
                    chooseAnotherOption();
                    break;
                case 5:
                    updateDogsHomeStatus();
                    chooseAnotherOption();
                    break;
                case 6:
                    System.out.println("Thank you. Good bye!");
                    break;
            }
        } else {
            System.out.println("Invalid choice. Try again");
            chooseMenuOptions();
        }
    }

    public static void chooseAnotherOption() {
        Scanner in = new Scanner(System.in);
        byte choice;
        System.out.println("Do you want to continue to work with system? \nPress 1 to continue \nPress 2 to exit");
        choice = in.nextByte();
        if (choice == 1) {
            chooseMenuOptions();
        } else if (choice == 2) {
            System.out.println("Thank you. Good bye!");
        } else {
            System.out.println("Invalid choice");
            chooseAnotherOption();
        }
    }

    public static void addDogToList() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the name of the dog you want to add");
        String name = in.next();
        System.out.println("Please enter the breed of the dog you want to add");
        String breed = in.next();
        System.out.println("Please enter the age of the dog you want to add");
        int age = in.nextInt();
        System.out.println("Please enter the sex of the dog you want to add");
        char sex = in.next().charAt(0);
        getListOfAllDog().add(new Dog());
        getListOfAllDog().get(getListOfAllDog().size()-1).setId(getListOfAllDog().size());
        getListOfAllDog().get(getListOfAllDog().size()-1).setAge(age);
        getListOfAllDog().get(getListOfAllDog().size()-1).setName(name);
        getListOfAllDog().get(getListOfAllDog().size()-1).setBreed(breed);
        getListOfAllDog().get(getListOfAllDog().size()-1).setSex(sex);
        System.out.println("You've added " + getListOfAllDog().get(getListOfAllDog().size()-1));
    }

    public static void viewAllDogs() {
        for (Dog list : getListOfAllDog()) {
            System.out.println(list.toString());
        }
    }

    public static void viewAllAvailableDogs() {
        for (int i = 0; i < listOfAllDogs.size(); i++) {
            if (!listOfAllDogs.get(i).isHasFoundHome()) {
                listOfHomelessDogs.add(listOfAllDogs.get(i));
                System.out.println(listOfHomelessDogs.get(i).toString());
            }
        }
    }

    public static void viewDogById() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter id of the dog");
        int id = in.nextInt();
        if (id <= listOfAllDogs.size()) {
            for (Dog list : listOfAllDogs) {
                if (id == list.getId()) {
                    System.out.println(list.toString());
                }
            }
        } else {
            System.out.println("There is no dog with that id");
        }
    }

    public static void updateDogsHomeStatus() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter id of the dog");
        int id = in.nextInt();
        if (id <= listOfAllDogs.size()) {
            listOfAllDogs.get(id-1).setHasFoundHome(true);
            System.out.println(listOfAllDogs.get(id-1).toString());
        } else {
            System.out.println("There is no dog with that id");
        }
    }
}
