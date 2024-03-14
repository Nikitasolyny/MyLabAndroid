package com.example.mylabandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylabandroid.databinding.FragmentArticleListBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import dataaccess.ArticleDTO;
import viewModels.ArticleListViewModel;

@AndroidEntryPoint
public class ArticleListFragment extends Fragment {
    @Inject
    public
    ArticleListViewModel viewModel;
    private final ArticleAdapter articleAdapter;
    public FragmentArticleListBinding binding;

    @Inject
    public ArticleListFragment(ArticleAdapter articleAdapter){
        this.articleAdapter = articleAdapter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentArticleListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        RecyclerView recyclerView = binding.recyclerView1;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(articleAdapter);

        viewModel.getArticles().observe(getViewLifecycleOwner(), articles -> {
            Log.i("I", "GET ARTICLES");
            articleAdapter.setData(articles);
        });

        articleAdapter.setOnItemClickListener(article -> {
            openArticleDetailFragment(article);
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= 10) {

                    viewModel.loadArticles();
                    Log.i("I", "LOAD ARTICLES");
                }
            }
        });

        return view;
    }

    private void openArticleDetailFragment(ArticleDTO article) {
        ArticleDetailFragment fragment = ArticleDetailFragment.newInstance(article);
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}