package com.example.mylibrary;

import android.util.Log;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;
    private static ArrayList<AllBooks> allBooks;
    private static ArrayList<AllBooks> readBooks;
    private static ArrayList<AllBooks> currentBooks;
    private static ArrayList<AllBooks> wishBooks;
    private static ArrayList<AllBooks> favourite;
    public static Utils getInstance() {
        if(null != instance)
             return instance;
        else {
            instance = new Utils();
            return instance;
        }

    }


    public Utils() {
        if(null==allBooks)
        {
            allBooks=new ArrayList<>();
            initData();
        }
        if(null==readBooks)
        {
            readBooks=new ArrayList<>();
        }
        if(null==currentBooks)
        {
           currentBooks=new ArrayList<>();
        }
        if(null==wishBooks)
        {
            wishBooks=new ArrayList<>();
        }
        if(null==favourite)
        {
            favourite=new ArrayList<>();
        }
    }
    private void initData(){

        String Long="Murder on the Orient Express Agatha Christie Pocket Books,\n"+" 1984 - Detective and mystery stories - 256 pages 40 Reviews On a three-day journey through the snowbound Balkan hills, Hercule Poirot must weed through an array of international suspects\n"+" to find the passenger who murdered a gangster on the Orient Express. ";
        allBooks.add(new AllBooks(1,"Murder","Agatha Christie",150,R.drawable.murder,"A brilliant work",Long));
         String Long2="Welcome to 2 States, a story about Krish and Ananya. \n"+"They are from two different states of India, deeply in love and want to get married.\n" +"Of course, their parents don’t agree. To convert their love story into a love marriage,\n"+ "the couple have a tough battle in front of them.For it is easy to fight and rebel, but it is much harder to convince.";
        allBooks.add(new AllBooks(2,"2 States","Chetan bhagath",150,R.drawable.states,"A brilliant work",Long2));
    }
    public AllBooks getBookById(int id){
        Log.d("all books started","yes");
       for(AllBooks b:allBooks)
       {
           if(b.getId()==id)
               return b;
       }
       return null;
    }


    public static ArrayList<AllBooks> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<AllBooks> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<AllBooks> getReadBooks() {
        return readBooks;
    }

    public static void setReadBooks(ArrayList<AllBooks> readBooks) {
        Utils.readBooks = readBooks;
    }

    public static ArrayList<AllBooks> getCurrentBooks() {
        return currentBooks;
    }

    public static void setCurrentBooks(ArrayList<AllBooks> currentBooks) {
        Utils.currentBooks = currentBooks;
    }
   public boolean addToAlreadyReadBooks(AllBooks book){
        return readBooks.add(book);
   }
    public boolean addToCurrentReadBooks(AllBooks book){
        return currentBooks.add(book);
    }
    public boolean addToCurrentFavBooks(AllBooks book){
        return favourite.add(book);
    }

    public static ArrayList<AllBooks> getWishBooks() {
        return wishBooks;
    }

    public static void setWishBooks(ArrayList<AllBooks> wishBooks) {
        Utils.wishBooks = wishBooks;
    }

    public static ArrayList<AllBooks> getFavourite() {
        return favourite;
    }

    public static void setFavourite(ArrayList<AllBooks> favourite) {
        Utils.favourite = favourite;
    }
}
