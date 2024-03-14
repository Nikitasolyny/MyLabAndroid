package com.example.mylabandroid;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylabandroid.databinding.ItemArticleBinding;

import java.util.ArrayList;
import java.util.List;
import dataaccess.ArticleDTO;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private final List<ArticleDTO> articles;
    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener {
        void onItemClick(ArticleDTO article);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public ArticleAdapter() {
        articles = new ArrayList<>();
    }

    public void setData(List<ArticleDTO> data) {
        articles.clear();
        articles.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticleBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_article, parent, false);
        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ArticleDTO article = articles.get(position);
        holder.binding.setArticle(article);
        holder.binding.executePendingBindings();

        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(article);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {
        private final ItemArticleBinding binding;
        public ArticleViewHolder(@NonNull ItemArticleBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
