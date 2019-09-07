package com.mcqtest.common.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mcqtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    private int mLayoutId;
    private Toolbar mToolbar;
    private TextView mToolbarTitle;

    public BaseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        FrameLayout fragmentLayoutContainer = view.findViewById(R.id.layout_container);
        inflater.inflate(mLayoutId, fragmentLayoutContainer);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        mToolbar = view.findViewById(R.id.tool_bar);
        mToolbarTitle = view.findViewById(R.id.toolbar_title);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();

        if (appCompatActivity != null) {
            appCompatActivity.setSupportActionBar(mToolbar);
            if (appCompatActivity.getSupportActionBar() != null) {
                appCompatActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                appCompatActivity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_btn);
                appCompatActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    protected void setLayout(int layoutId) {
        mLayoutId = layoutId;
    }

    public void showToolbar() {
        if (mToolbar != null) {
            mToolbar.setVisibility(View.VISIBLE);
        }
    }

    public void hideToolbar() {
        if (mToolbar != null) {
            mToolbar.setVisibility(View.GONE);
        }
    }

    public void setToolbarTitle(String title) {
        if (mToolbarTitle != null) {
            mToolbarTitle.setText(title);
        }
    }

}
