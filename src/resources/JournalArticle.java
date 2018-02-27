package resources;

import java.util.List;

public class JournalArticle extends Journal {
    JournalArticle(){
        super();
    }

    public List<String> getArticleAuthors() {
        return articleAuthors;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public Journal getJournalOfArticle() {
        return journalOfArticle;
    }

    protected List<String> articleAuthors;
    protected String articleTitle;
    Journal journalOfArticle;

}
