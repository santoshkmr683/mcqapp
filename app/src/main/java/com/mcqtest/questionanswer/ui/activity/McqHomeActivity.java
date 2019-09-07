package com.mcqtest.questionanswer.ui.activity;

import android.os.Bundle;

import com.mcqtest.R;
import com.mcqtest.common.ui.activity.BaseActivity;
import com.mcqtest.common.util.FragmentHelper;
import com.mcqtest.questionanswer.ui.fragment.McqFragment;
import com.mcqtest.questionanswer.ui.fragment.McqHomeFragment;

public class McqHomeActivity extends BaseActivity implements
        McqHomeFragment.FragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentHelper.replaceFragment(this, McqHomeFragment.newInstance(), R.id.fragment_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_mcq_home;
    }

    @Override
    public void onStartQuizButtonClick() {
        FragmentHelper.addFragment(this, McqFragment.newInstance(), R.id.fragment_container);
    }
}
