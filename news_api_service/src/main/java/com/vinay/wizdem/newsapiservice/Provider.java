package com.vinay.wizdem.newsapiservice;

import com.vinay.wizdem.newsapiservice.Models.Article;
import com.vinay.wizdem.newsapiservice.Models.NewsFeed;
import com.vinay.wizdem.newsapiservice.Rest.ApiClient;
import com.vinay.wizdem.newsapiservice.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vinay_1 on 1/24/2018.
 */

public class Provider {
    private NewsFeed newsFeed;
    private List<Article> articles;
    ProviderInterface providerInterface;

    public Provider(ProviderInterface providerInterface){
        this.providerInterface = providerInterface;
    }

    public void onNewsRequest() {
        newsFeed = new NewsFeed();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NewsFeed> call = apiInterface.getNewsFeeds("us", "94ad4c3e4c3540faab7204b34fc16532");
        call.enqueue(new Callback<NewsFeed>() {
            @Override
            public void onResponse(Call<NewsFeed> call, Response<NewsFeed> response) {
                if (response != null) {
                    newsFeed = response.body();
                    if (newsFeed.getArticles() != null) {
                        articles = newsFeed.getArticles();
                    }
                }else {
                    providerInterface.onEmptyResoponse();
                }
            }

            @Override
            public void onFailure(Call<NewsFeed> call, Throwable t) {
                providerInterface.onFailure();
            }
        });
    }

    public void onArticleRequest() {

        providerInterface.onArticleResponse(articles);
    }
}
