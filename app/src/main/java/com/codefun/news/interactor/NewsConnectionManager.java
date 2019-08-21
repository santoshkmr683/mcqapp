package com.codefun.news.interactor;

import android.content.Context;

import com.codefun.common.networkutil.APICallback;
import com.codefun.common.networkutil.APIServiceUtil;
import com.codefun.news.model.NewsResponse;

import retrofit2.Call;

public class NewsConnectionManager {

    public static void getNewsDetails(Context context, APICallback<NewsResponse> callback) {
        String url = "everything?q=bitcoin&from=2019-08-17&sortBy=publishedAt&apiKey=1e4917c4ba964f4a99987ce28c83152f";
        Call<NewsResponse> callObj = APIServiceUtil.getInstance(context).getApiInterface()
                .getNewsResponse(url);
        callObj.enqueue(callback);
    }
}
