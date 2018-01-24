package com.vinay.wizdem.viacomamp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vinay.wizdem.newsapiservice.Models.Article;

import java.util.List;

/**
 * Created by vinay_1 on 1/24/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{
    private List<Article> articles;

    public MainAdapter(List<Article> articles){
        this.articles = articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MainAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.article.setText(String.valueOf(articles.get(position).getTitle()));
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView article;
        public ViewHolder(View itemView) {
            super(itemView);
            article =(TextView)itemView.findViewById(R.id.article);
        }
    }
}
