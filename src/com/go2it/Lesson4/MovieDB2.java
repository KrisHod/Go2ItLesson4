package com.go2it.Lesson4;

import java.util.Scanner;

public class MovieDB2 {
    private int reviewer;
    private int movie;
    private int[][] dataBase = new int[reviewer][movie];
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

    public int[][] initializeDataBase() {
        for (int i = 0; i < getReviewer(); i++) {
            System.out.println("Your are reviewer number is " + i);
            for (int j = 0; j < getMovie(); j++) {
                System.out.println("Please enter your rating for movie number " + j);
                dataBase[i][j] = getInput().nextInt();
            }
        }
        return dataBase;
    }


    public double calculateAverageRatingForMovie(MovieDB2 movieDB2) {
        System.out.println("Please enter the number of movie you want to see the rating for: ");
        int movieNumber = input.nextInt();
        double sum = 0;
        double averageRatingForMovie = 0;
        for (int i = 0; i < movieDB2.getReviewer(); i++) {
            sum += movieDB2.getDataBase()[i][movieNumber];
            averageRatingForMovie = sum / movieDB2.getReviewer();
        }
        return averageRatingForMovie;
    }

    public double calculateAverageRatingForReviewer(MovieDB2 movieDB2) {
        System.out.println("Please enter the number of reviewer whose rating you want to see: ");
        int reviewerNumber = input.nextInt();
        double sum = 0;
        double averageRatingForReviewer = 0;
        for (int i = 0; i < movieDB2.getMovie(); i++) {
            sum += movieDB2.getDataBase()[reviewerNumber][i];
            averageRatingForReviewer = sum / movieDB2.getMovie();
        }
        return averageRatingForReviewer;
    }
}
