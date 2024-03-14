package com.example.mylabandroid;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import dataaccess.ArticleDTO;
import dataaccess.ArticleResultsDTO;
import dataaccess.SchedulerProvider;
import dataaccess.interfaces.ApiService;
import dataaccess.repositories.ArticleRepositoryImpl;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArticleRepositoryImplTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    ApiService mockApiService;

    @Mock
    SchedulerProvider mockSchedulerProvider;

    ArticleRepositoryImpl articleRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        articleRepository = new ArticleRepositoryImpl(mockApiService, mockSchedulerProvider);
    }

    @Test
    public void testGetArticlesLiveData() {
        List<ArticleDTO> dummyArticles = new ArrayList<>();
        dummyArticles.add(new ArticleDTO());
        dummyArticles.add(new ArticleDTO());

        MutableLiveData<List<ArticleDTO>> liveData = new MutableLiveData<>();
        liveData.setValue(dummyArticles);
        ArticleResultsDTO result = new ArticleResultsDTO();
        result.setResults(dummyArticles.toArray(new ArticleDTO[0]));

        when(mockSchedulerProvider.io()).thenReturn(Schedulers.trampoline());
        when(mockSchedulerProvider.ui()).thenReturn(Schedulers.trampoline());
        when(mockApiService.getArticles(Mockito.anyInt(), Mockito.anyInt())).thenReturn(Observable.just(result));

        LiveData<List<ArticleDTO>> resultLiveData = articleRepository.getArticlesLiveData();

        assertEquals(liveData.getValue(), resultLiveData.getValue());
        verify(mockApiService).getArticles(anyInt(), anyInt());
    }
}