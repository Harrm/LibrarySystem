package com.lsd.library;

import java.util.ArrayList;

/* This is the class of Books, which extends the class Document
 */
public class Book extends Document{

    //creation of the constructor for the book, including all its features
    //keyWords are the words that the user introduces when looking for a book (the introduced words may not be the exact name of a book).
    Book(ArrayList<String> authors, String publisher, String title, int publicationYear, String edition, int numberOfAvailableCopies, int price){
        this.authors = authors;
        this.publisher = publisher;
        this.title = title;
        this.publicationYear = publicationYear;
        this.edition = edition;
        this.numberOfAvailableCopies = numberOfAvailableCopies;
        this.price = price;
        keyWords = new ArrayList<>();
        for (String keyWord: authors){
            keyWords.add(keyWord);
        }
        keyWords.add(publisher);
    }

    //We set if the book will be a bestSeller
    void setBestSeller(boolean bestSeller){
        this.bestSeller = bestSeller;
    }

    //and with this method we identify is a book is a bestSeller
    boolean isBestSeller(){
        return  bestSeller;
    }

    //we create the attribute for a bestSeller here
    boolean bestSeller;
}
