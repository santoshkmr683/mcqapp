package com.mcqtest.questionanswer.ui.fragment;

import android.annotation.SuppressLint;
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
import com.mcqtest.common.util.Bus;
import com.mcqtest.common.util.Constant;

public class ScoreDisplayDialogFragment extends DialogFragment {

    private int mTotalQuestion;
    private int mTotalScore;

    public static ScoreDisplayDialogFragment newInstance(int totalQuestion, int totalScore) {

        Bundle args = new Bundle();
        args.putInt(Constant.TOTAL_QUESTION, totalQuestion);
        args.putInt(Constant.TOTAL_SCORE, totalScore);
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
        getDataFromBundle();
        initView(view);
    }

    private void getDataFromBundle() {
        if (getArguments() != null) {
            mTotalQuestion = getArguments().getInt(Constant.TOTAL_QUESTION);
            mTotalScore = getArguments().getInt(Constant.TOTAL_SCORE);
        }
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

    @SuppressLint("DefaultLocale")
    private void initView(View view) {
        TextView mTotalQuizQues = view.findViewById(R.id.total_no_ques_value);
        TextView mTotalScoreTv = view.findViewById(R.id.total_score_value);

        mTotalQuizQues.setText(String.valueOf(mTotalQuestion));
        mTotalScoreTv.setText(String.format("%d/%d", mTotalScore, mTotalQuestion));

        view.findViewById(R.id.ok_btn).setOnClickListener(v -> {
            getDialog().dismiss();
           if (getActivity() != null) {
               Bus.postScoreOkClickEvent(String.format("%d/%d", mTotalScore, mTotalQuestion));
               getActivity().onBackPressed();
           }
        });
    }

}
