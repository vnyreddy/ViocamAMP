package com.vinay.wizdem.newsapiservice.Rest;

import com.vinay.wizdem.newsapiservice.Models.NewsFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vinay_1 on 1/24/2018.
 */

public interface ApiInterface {
    @GET("top-headlines")
    Call<NewsFeed> getNewsFeeds(@Query("country") String country, @Query("apiKey") String API_KEY);
}
