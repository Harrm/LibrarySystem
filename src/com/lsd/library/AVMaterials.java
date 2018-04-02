package com.lsd.library;

import java.util.ArrayList;
import java.util.List;

//class of the AVMaterials, inheriting from the class Document

public class AVMaterials extends Document {
    AVMaterials(String title, ArrayList<String> authors, int price){
        this.title = title;
        this.authors = authors;
        this.price = price;
        keyWords = new ArrayList<>();
        for (String keyWord: authors){
            keyWords.add(keyWord);
        }
    }
}
