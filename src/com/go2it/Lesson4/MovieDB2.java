package com.go2it.Lesson4;

import java.util.Scanner;

public class MovieDB2 {
    private int reviewer;
    private int movie;
    private int [][] dataBase = new int[reviewer][movie];
    private Scanner input;

    public MovieDB2(int reviewer, int movie) {
        this.reviewer = reviewer;
        this.movie = movie;
        this.dataBase = new int[this.reviewer][this.movie];
        this.input = new Scanner(System.in);
    }

    public int getReviewer() {
        return reviewer;
    }

    public void setReviewer(int reviewer) {
        this.reviewer = reviewer;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }

    public int[][] getDataBase() {
        return dataBase;
    }

    public void setDataBase(int[][] dataBase) {
        this.dataBase = dataBase;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public int [][] initializeDataBase () {
        for (int i = 0; i < getReviewer(); i++) {
            System.out.println("Your are reviewer number is " + i);
            for (int j = 0; j < getMovie(); j++) {
                System.out.println("Please enter your rating for movie number " + j);
                dataBase[i][j] = getInput().nextInt();
            }
        }
        return dataBase;
    }
}
