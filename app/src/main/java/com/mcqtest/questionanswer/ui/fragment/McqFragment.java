package com.mcqtest.questionanswer.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcqtest.R;
import com.mcqtest.common.ui.fragment.BaseFragment;
import com.mcqtest.common.util.McqUtil;
import com.mcqtest.questionanswer.model.MCQ;
import com.mcqtest.questionanswer.ui.adapter.QuestionListAdapter;

import java.util.List;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class McqFragment extends BaseFragment implements
        QuestionListAdapter.AdapterSubmitClickListener,
        ScoreDisplayDialogFragment.DialogFragmentInteractionListener {


    public McqFragment() {
        // Required empty public constructor
    }

    public static McqFragment newInstance() {

        Bundle args = new Bundle();

        McqFragment fragment = new McqFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_mcq);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        showToolbar();
        setToolbarTitle("MCQ Question Quiz");
    }

    private void initView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new QuestionListAdapter(getContext(), McqUtil
                .getMcqQuesAnsList(getContext()), this));
    }

    @Override
    public void onSubmitButtonClick(List<MCQ> mcqList) {
        if (getActivity() != null) {
            int totalScore = 0;
            for (int i = 0; i < mcqList.size(); i++) {
                for (int j = 0; j < mcqList.get(i).getOptionList().size(); j++) {
                    if (mcqList.get(i).getOptionList().get(j).isCorrectAns() &&
                            mcqList.get(i).getOptionList().get(j).isSelected()) {
                        totalScore++;
                    }
                }
            }
            ScoreDisplayDialogFragment.newInstance(mcqList.size(), totalScore,
                    this).show(getActivity()
                    .getSupportFragmentManager(), "score dialog");
        }
    }

    @Override
    public void onOkButtonClick() {
        if (getActivity() != null){
            getActivity().finish();
        }
    }
}
