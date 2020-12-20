package com.go2it.Lesson4.additionalHW;

import java.util.ArrayList;

public class Dog {
    private int id;
    private String name;
    private double age;
    private String breed;
    private char sex;
    private boolean hasFoundHome;


//    public Dog(String breed, char sex) {
//        this.breed = breed;
//        this.sex = sex;
//        this.hasFoundHome = false;
//    }
//
//    public Dog(String name, String breed, char sex) {
//        this.name = name;
//        this.breed = breed;
//        this.sex = sex;
//        this.hasFoundHome = false;
//    }
//
//    public Dog(String name, double age, String breed, char sex, int id) {
//        this.name = name;
//        this.age = age;
//        this.breed = breed;
//        this.sex = sex;
//        this.id = id;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        if (age > 0 && age < 25) {
            this.age = age;
        } else {
            System.out.println("Invalid age");
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        if (sex=='f' || sex=='m') {
            this.sex = sex;
        }
        else {
            System.out.println("Invalid sex");
        }
    }

    public boolean isHasFoundHome() {
        return hasFoundHome;
    }

    public void setHasFoundHome(boolean hasFoundHome) {
        this.hasFoundHome = hasFoundHome;
    }

    @Override
    public String toString() {
        return "Dog {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", sex=" + sex +
                ", hasFoundHome=" + hasFoundHome +
                '}';
    }
}
