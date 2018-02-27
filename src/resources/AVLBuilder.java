package resources;

import java.util.List;

public class AVLBuilder {

    public AVLMaterial build(){

        AVLMaterial avlMaterial = new AVLMaterial();

        avlMaterial.title = title;
        avlMaterial.authors = authors;
        avlMaterial.price = price;
        avlMaterial.keyWords = keyWords;
        avlMaterial.numberOfCopies = numberOfCopies;

        return avlMaterial;
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
