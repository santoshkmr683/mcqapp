package com.codefun.news.ui.activity;

import android.os.Bundle;

import com.codefun.R;
import com.codefun.common.ui.activity.BaseActivity;
import com.codefun.common.util.FragmentHelper;
import com.codefun.questionanswer.ui.fragment.QuestionAnswerFragment;

public class NewsFeedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //FragmentHelper.replaceFragment(this, NewsFeedFragment.newInstance(), R.id.fragment_container);
        FragmentHelper.replaceFragment(this, QuestionAnswerFragment.newInstance(), R.id.fragment_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_news_feed;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
