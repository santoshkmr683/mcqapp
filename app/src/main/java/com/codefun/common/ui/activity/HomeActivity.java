package com.codefun.common.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codefun.R;
import com.codefun.news.ui.activity.NewsFeedActivity;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.btn_news_feed).setOnClickListener(this);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_news_feed) {
            startActivity(new Intent(this, NewsFeedActivity.class));
        }
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
