package com.example.mylabandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.mylabandroid.databinding.FragmentArticleDetailBinding;

import dagger.hilt.android.AndroidEntryPoint;
import dataaccess.ArticleDTO;

@AndroidEntryPoint
public class ArticleDetailFragment extends Fragment {
    public ArticleDTO selectedArticle;
    private static final String ARG_ARTICLE = "article";
    public FragmentArticleDetailBinding binding;

    public static ArticleDetailFragment newInstance(ArticleDTO article) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ARTICLE, article);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedArticle = getArguments().getParcelable(ARG_ARTICLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_article_detail, container, false);
        View view = binding.getRoot();

        if (selectedArticle != null) {
            binding.setArticle(selectedArticle);
            binding.executePendingBindings();
        }

        return view;
    }

}
