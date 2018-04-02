package com.lsd.library;

import java.util.ArrayList;

public class JournalArticle extends Document {
    JournalArticle(ArrayList<String> authors, String publisher, String title, int publicationYear, String edition, int numberOfAvailableCopies, String journal, String editor, int price){
        this.authors = authors;
        this.publisher = publisher;
        this.title = title;
        this.publicationYear = publicationYear;
        this.edition = edition;
        this.numberOfAvailableCopies = numberOfAvailableCopies;
        this.journal = journal;
        this.editor = editor;
        this.price = price;
        keyWords = new ArrayList<>();
        for (String keyWord: authors){
            keyWords.add(keyWord);
        }
        keyWords.add(publisher);
    }
    String journal;
    String editor;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }


}
