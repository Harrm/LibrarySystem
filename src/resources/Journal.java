package resources;

import java.time.LocalDate;
import java.util.List;

public class Journal{

    Journal(){

    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public String getIssuesPublisher() {
        return issuesPublisher;
    }

    public List<String> getIssueEditors() {
        return issueEditors;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    protected String journalTitle;
    protected String issuesPublisher;
    protected List<String> issueEditors;
    protected LocalDate issueDate;
    protected int numberOfCopies;
    protected int price; //price of the document
    protected List<String> keyWords;

}
