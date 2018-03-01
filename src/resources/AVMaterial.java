package resources;

import java.util.List;

public class AVMaterial {
    AVMaterial(){
        
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

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    protected String title;
    protected List<String> authors;
    protected int price; //price of the document
    protected List<String> keyWords; //list of words that are introduced by the user when searching for a document
    protected int numberOfCopies;
}
