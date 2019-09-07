package com.mcqtest.questionanswer.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.mcqtest.R;

public class ScoreDisplayDialogFragment extends DialogFragment {

    private TextView mTotalQuizQues;
    private TextView mTotalAttempted;
    private TextView mTotalScore;


    public static ScoreDisplayDialogFragment newInstance() {

        Bundle args = new Bundle();

        ScoreDisplayDialogFragment fragment = new ScoreDisplayDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        if (null != getDialog() && null != getDialog().getWindow()) {
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return inflater.inflate(R.layout.score_display_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && dialog.getWindow() != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }

    private void initView(View view) {
        mTotalQuizQues = view.findViewById(R.id.total_no_ques_value);
        mTotalAttempted = view.findViewById(R.id.total_attempted_value);
        mTotalScore = view.findViewById(R.id.total_score_value);

        view.findViewById(R.id.ok_btn).setOnClickListener(v -> getDialog().dismiss());
    }
}
