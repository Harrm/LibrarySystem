package resources;

import java.util.List;

public class JournalArticleBuilder extends JournalBuilder {


    public JournalArticle build(){

        JournalArticle journalArticle = new JournalArticle();

        journalArticle.articleAuthors = articleAuthors;
        journalArticle.journalOfArticle = journalOfArticle;
        journalArticle.articleTitle = articleTitle;

        return journalArticle;
    }

    public void setArticleAuthors(List<String> articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public void setJournalOfArticle(Journal journalOfArticle) {
        this.journalOfArticle = journalOfArticle;
    }

    private List<String> articleAuthors;
    private String articleTitle;
    private Journal journalOfArticle;
}
