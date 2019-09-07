package com.mcqtest.questionanswer.ui.activity;

import android.os.Bundle;

import com.mcqtest.R;
import com.mcqtest.common.ui.activity.BaseActivity;
import com.mcqtest.common.util.FragmentHelper;
import com.mcqtest.questionanswer.ui.fragment.McqFragment;

public class McqHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentHelper.replaceFragment(this, McqFragment.newInstance(), R.id.fragment_container);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_mcq_home;
    }

}
