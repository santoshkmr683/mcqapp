package com.codefun.questionanswer.ui.activity;

import android.os.Bundle;

import com.codefun.R;
import com.codefun.common.ui.activity.BaseActivity;
import com.codefun.common.util.FragmentHelper;
import com.codefun.questionanswer.ui.fragment.McqFragment;

public class QuestionAnswerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentHelper.replaceFragment(this, McqFragment.newInstance(), R.id.fragment_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_question_answer;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
