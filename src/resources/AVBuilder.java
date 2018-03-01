package resources;

import java.util.List;

public class AVBuilder {

    public AVMaterial build(){

        AVMaterial avMaterial = new AVMaterial();

        avMaterial.title = title;
        avMaterial.authors = authors;
        avMaterial.price = price;
        avMaterial.keyWords = keyWords;
        avMaterial.numberOfCopies = numberOfCopies;

        return avMaterial;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    private String title;
    private List<String> authors;
    private int price; //price of the document
    private List<String> keyWords; //list of words that are introduced by the user when searching for a document
    private int numberOfCopies;
}
