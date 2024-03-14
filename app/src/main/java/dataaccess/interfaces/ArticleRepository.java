package dataaccess.interfaces;

import androidx.lifecycle.LiveData;

import java.util.List;

import dataaccess.ArticleDTO;

public interface ArticleRepository {
    LiveData<List<ArticleDTO>> getArticlesLiveData();
    void loadArticles();
}
