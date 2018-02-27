package resources;

import java.time.LocalDate;
import java.util.List;

public class JournalBuilder {

    public Journal build(){

        Journal journal = new Journal();

        journal.numberOfCopies = numberOfCopies;
        journal.keyWords = keyWords;
        journal.price = price;
        journal.issueDate = issueDate;
        journal.issueEditors = issueEditors;
        journal.issuesPublisher = issuesPublisher;
        journal.journalTitle = journalTitle;

        return journal;
    }


    public void setJournalTitle(String journalTitle) {
        this.journalTitle = journalTitle;
    }

    public void setIssuesPublisher(String issuesPublisher) {
        this.issuesPublisher = issuesPublisher;
    }

    public void setIssueEditors(List<String> issueEditors) {
        this.issueEditors = issueEditors;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }



    private String journalTitle;
    private String issuesPublisher;
    private List<String> issueEditors;
    private LocalDate issueDate;
    private int numberOfCopies;
    private int price; //price of the document
    private List<String> keyWords;
    
}
