package com.example.mylabandroid;

import android.os.Bundle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import dataaccess.ArticleDTO;

public class ArticleDetailFragmentTest {

    private ArticleDetailFragment fragment;
    private ArticleDTO mockArticleDTO;

    @Mock
    private Bundle mockBundle;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        fragment = new ArticleDetailFragment();
        mockArticleDTO = new ArticleDTO();
    }

    @Test
    public void testFragmentInitialization() {
        when(mockBundle.getParcelable("article")).thenReturn(mockArticleDTO);
        fragment.setArguments(mockBundle);

        assertEquals(mockArticleDTO, fragment.getArguments().getParcelable("article"));
    }

    @Test
    public void testFragmentCreationWithNullArguments() {
        fragment.setArguments(null);

        assertEquals(null, fragment.selectedArticle);
    }
}
