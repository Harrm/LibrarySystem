package resources;

import java.time.LocalDate;
import java.util.List;

public class BookBuilder {

    public Book build(){
        Book book = new Book();
        book.authors = authors;
        book.numberOfCopies = numberOfCopies;
        book.keyWords = keyWords;
        book.price = price;
        book.publicationYear = publicationYear;
        book.reference = reference;
        book.bestseller = bestseller;
        book.publisher = publisher;
        book.title = title;
        book.edition = edition;
        return book;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setnumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void setPublicationYear(LocalDate publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAsReference() {
        this.reference = true;
    }

    public void setAsNonReference() {
        this.reference = false;
    }

    public void setAsBestseller() {
        this.bestseller = true;
    }

    public void setAsNonBestseller() {
        this.bestseller = false;
    }

    public void setEdition(String edition){this.edition = edition; }

    private List<String> authors;
    private String publisher;
    private String title;
    private String edition;
    private LocalDate publicationYear;
    private int numberOfCopies;
    private int price; //price of the document
    private List<String> keyWords; //list of words that are introduced by the user when searching for a document
    private boolean bestseller;
    private boolean reference;
}
