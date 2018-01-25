package com.vinay.wizdem.viacomamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.vinay.wizdem.newsapiservice.Models.Article;
import com.vinay.wizdem.newsapiservice.Provider;
import com.vinay.wizdem.newsapiservice.ProviderInterface;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ProviderInterface {

    private RecyclerView mRecyclerView;
    private MainAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles;
    private Provider provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        getInterface();
    }

    private void displayList(){
        adapter = new MainAdapter(articles);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    private void getInterface(){
        provider =new Provider(this);
        provider.onNewsRequest();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getApplicationContext(), "Api Request failure", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSucess() {
        provider.onArticleRequest();
    }

    @Override
    public void onEmptyResoponse() {
    }

    @Override
    public void onArticleResponse(List<Article> articles) {

        this.articles = articles;
        displayList();
    }


}
