package resources;

import java.time.LocalDate;
import java.util.List;

public class Book {
    Book (){

    }

    public boolean isReference() {
        return reference;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getEdition() {
        return edition;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public int getnumberOfCopies() {
        return numberOfCopies;
    }

    boolean bestseller;
    boolean reference;
    protected String publisher;
    protected String edition;
    protected LocalDate publicationYear;
    protected String title;
    protected List<String> authors;
    protected int price; //price of the document
    protected List<String> keyWords; //list of words that are introduced by the user when searching for a document
    protected int numberOfCopies;

}
