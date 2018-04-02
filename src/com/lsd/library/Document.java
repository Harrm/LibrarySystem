package com.lsd.library;

import java.util.ArrayList;

/* class Document. This is the upper class where we give the general features to the documents that are stored in the library

 */
public class Document {
    Document(){ //constructor by default
    }

    //The following are the attributes that a document must have
    ArrayList<String> authors;
    String publisher;
    String title;
    String edition;
    int publicationYear;
    int numberOfAvailableCopies;
    int price; //price of the document
    ArrayList<String> keyWords; //list of words that are introduced by the user when searching for a document


    //And in the following methods, we create the getters for each attribute of the document

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberOfAvailableCopies() {
        return numberOfAvailableCopies;
    }

    public void setNumberOfAvailableCopies(int numberOfAvailableCopies) {
        this.numberOfAvailableCopies = numberOfAvailableCopies;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }


}
