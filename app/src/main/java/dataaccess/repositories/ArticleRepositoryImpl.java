package dataaccess.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dataaccess.ArticleDTO;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;
import dataaccess.interfaces.ArticleRepository;
import io.reactivex.disposables.CompositeDisposable;

public class ArticleRepositoryImpl implements ArticleRepository {
    private final ApiService apiService;
    private final SchedulerProvider schedulerProvider;
    private final MutableLiveData<List<ArticleDTO>> articlesLiveData = new MutableLiveData<>();
    private final List<ArticleDTO> articleList = new ArrayList<>();
    private boolean isLoading = false;
    public final CompositeDisposable disposable;
    private int limit = 10;
    private int offset = 0;

    @Inject
    public ArticleRepositoryImpl(ApiService apiService, SchedulerProvider schedulerProvider) {
        disposable = new CompositeDisposable();

        this.apiService = apiService;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public LiveData<List<ArticleDTO>> getArticlesLiveData() {
        loadArticles();
        return articlesLiveData;
    }

    @Override
    public void loadArticles() {
        if (!isLoading) {
            isLoading = true;
            disposable.add(
                    apiService.getArticles(limit, offset)
                            .subscribeOn(schedulerProvider.io())
                            .observeOn(schedulerProvider.ui())
                            .subscribe(articleResponse -> {
                                articleList.addAll(Arrays.asList(articleResponse.getResult()));
                                offset += limit;
                                articlesLiveData.postValue(articleList);
                                isLoading = false;
                            }, throwable -> {
                                throwable.printStackTrace();
                                isLoading = false;
                            })
            );
        }
    }
}
