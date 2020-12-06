package com.go2it.Lesson4;

public class MovieDB2Main {
    public static void main(String[] args) {
        MovieDB2 movieDB2 = new MovieDB2(2,3);
        movieDB2.initializeDataBase();

        for (int[] arr: movieDB2.getDataBase()) {
            for (int arr2:arr) {
                System.out.println(arr2);
            }
        }

        System.out.println(movieDB2.calculateAverageRatingForMovie(movieDB2));
        System.out.println(movieDB2.calculateAverageRatingForReviewer(movieDB2));
    }
}
