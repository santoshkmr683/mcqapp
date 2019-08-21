package com.codefun.news.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codefun.R;
import com.codefun.common.ui.fragment.BaseFragment;
import com.codefun.news.model.NewsResponse;
import com.codefun.news.presenter.NewDetailsPresenter;
import com.codefun.news.ui.adapter.NewsListAdapter;
import com.codefun.news.view.NewsDetailsView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFeedFragment extends BaseFragment implements NewsDetailsView,
        NewsListAdapter.RecyclerItemClickListener {

    private RecyclerView mRecyclerView;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    public static NewsFeedFragment newInstance() {

        Bundle args = new Bundle();

        NewsFeedFragment fragment = new NewsFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setLayout(R.layout.fragment_news_feed);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        callNewsDetailsApi();
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
    }

    private void callNewsDetailsApi() {
        NewDetailsPresenter newDetailsPresenter = new NewDetailsPresenter(this);
        newDetailsPresenter.getNewsDetails(getContext());
        showProgressBar();
    }

    @Override
    public void onNewDetailsGetSuccess(NewsResponse newsResponse) {
        hideProgressBar();
        if (newsResponse != null && newsResponse.getStatus().equalsIgnoreCase("ok")) {
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(new NewsListAdapter(getContext(),
                    newsResponse.getArticles(), this));
        }
    }

    @Override
    public void onItemClick() {

    }
}
