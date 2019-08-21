package com.codefun.common.networkutil;

import com.codefun.news.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIInterface {

    @GET
    Call<NewsResponse> getNewsResponse(@Url String url);
}
