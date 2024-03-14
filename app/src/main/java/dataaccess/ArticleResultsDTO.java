package dataaccess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleResultsDTO {
    @SerializedName("next")
    @Expose
    private String next;

    @SerializedName("previous")
    @Expose
    private String previous;

    @SerializedName("results")
    @Expose
    private ArticleDTO[] results;

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public ArticleDTO[] getResult() {
        return results;
    }

    public void setNext(String next) {
        this.next= next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setResults(ArticleDTO[] results) {
        this.results = results;
    }
}
