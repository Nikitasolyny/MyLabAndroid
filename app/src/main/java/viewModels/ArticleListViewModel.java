package viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import dataaccess.ArticleDTO;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;
import dataaccess.interfaces.ArticleRepository;
import io.reactivex.disposables.CompositeDisposable;

@HiltViewModel
public class ArticleListViewModel extends ViewModel {
    private final ArticleRepository articleRepository;

    @Inject
    public ArticleListViewModel(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public LiveData<List<ArticleDTO>> getArticles() {
        return articleRepository.getArticlesLiveData();
    }

    public void loadArticles() {
        articleRepository.loadArticles();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
