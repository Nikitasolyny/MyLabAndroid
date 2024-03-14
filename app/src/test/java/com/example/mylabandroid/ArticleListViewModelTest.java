package com.example.mylabandroid;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import dataaccess.ArticleDTO;
import dataaccess.interfaces.ArticleRepository;
import viewModels.ArticleListViewModel;

@RunWith(MockitoJUnitRunner.class)
public class ArticleListViewModelTest {

    @Rule
    public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

    @Mock
    ArticleRepository mockArticleRepository;

    @Mock
    Observer<List<ArticleDTO>> mockObserver;

    ArticleListViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ArticleListViewModel(mockArticleRepository);
    }

    @Test
    public void testGetArticles() {
        List<ArticleDTO> dummyArticles = new ArrayList<>();
        dummyArticles.add(new ArticleDTO());
        dummyArticles.add(new ArticleDTO());

        MutableLiveData<List<ArticleDTO>> liveData = new MutableLiveData<>();
        liveData.setValue(dummyArticles);

        Mockito.when(mockArticleRepository.getArticlesLiveData()).thenReturn(liveData);

        viewModel.getArticles().observeForever(mockObserver);

        Mockito.verify(mockObserver).onChanged(dummyArticles);
    }

    @Test
    public void testLoadArticles() {
        viewModel.loadArticles();

        Mockito.verify(mockArticleRepository).loadArticles();
    }
}
