package com.codefun.common.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.codefun.R;
import com.codefun.common.view.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements BaseView {

    private int mLayoutId;

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

    protected void setLayout(int layoutId) {
        mLayoutId = layoutId;
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
