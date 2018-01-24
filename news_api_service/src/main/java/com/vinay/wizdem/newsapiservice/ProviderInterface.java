package com.vinay.wizdem.newsapiservice;

import com.vinay.wizdem.newsapiservice.Models.Article;

import java.util.List;

/**
 * Created by vinay_1 on 1/24/2018.
 */

public interface ProviderInterface {
    void onFailure();
    void onSucess();
    void onEmptyResoponse();
    void onArticleResponse(List<Article> articles);
}
