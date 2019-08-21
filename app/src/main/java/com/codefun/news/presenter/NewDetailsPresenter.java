package com.codefun.news.presenter;

import android.content.Context;
import android.widget.Toast;

import com.codefun.common.networkutil.APICallback;
import com.codefun.common.presenter.BasePresenter;
import com.codefun.common.view.BaseView;
import com.codefun.news.interactor.NewsConnectionManager;
import com.codefun.news.model.NewsResponse;
import com.codefun.news.view.NewsDetailsView;

public class NewDetailsPresenter extends BasePresenter {

    public NewDetailsPresenter(BaseView baseView) {
        super(baseView);
    }

    public void getNewsDetails(final Context context) {
        if (!isNetworkAvailable(context)) {

            Toast.makeText(context, "Please check your network connection...and try again",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        NewsConnectionManager.getNewsDetails(context, new APICallback<NewsResponse>(context) {
            @Override
            public void onResponseSuccess(NewsResponse newsResponse) {
                NewsDetailsView view = (NewsDetailsView) getView();
                if (view == null) {
                    return;
                }
                view.onNewDetailsGetSuccess(newsResponse);
            }

            @Override
            public void onResponseFailure(String errorMessage) {
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
