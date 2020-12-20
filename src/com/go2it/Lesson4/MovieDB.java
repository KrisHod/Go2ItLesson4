//package com.go2it.Lesson4;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class MovieDB {
//
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println("Please enter number of reviewers");
//        int reviewers = in.nextInt();
//        System.out.println("Please enter number of movies");
//        int movies = in.nextInt();
//        int rating;
//        double averageRatingForMovie;
//
//        List<ArrayList<Integer>> arrOfReviewersAndMovies = new ArrayList();
//
//        for (int i = 0; i < reviewers; i++) {
//            ArrayList<Integer> arrOfMovies = new ArrayList<>();
//            System.out.println("Your are reviewer number " + i);
//            for (int j = 0; j < movies; j++) {
//                System.out.println("Please enter your rating for movie number " + j);
//                rating = in.nextInt();
//                arrOfMovies.add(rating);
//            }
//            arrOfReviewersAndMovies.add(arrOfMovies);
//        }
//        System.out.println(arrOfReviewersAndMovies);
//    }
//}
//
//
//
//
//
