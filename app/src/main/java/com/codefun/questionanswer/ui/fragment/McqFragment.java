package com.codefun.questionanswer.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codefun.R;
import com.codefun.common.ui.fragment.BaseFragment;
import com.codefun.common.util.CodeFunUtil;
import com.codefun.questionanswer.ui.adapter.QuestionListAdapter;

/**
 * A simple {@link BaseFragment} subclass.
 */
public class McqFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

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
        mRecyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(new QuestionListAdapter(getContext(), CodeFunUtil
                .getMcqQuesAnsList(getContext())));
    }
}