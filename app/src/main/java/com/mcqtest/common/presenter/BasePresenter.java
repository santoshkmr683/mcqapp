package com.mcqtest.common.presenter;

import android.content.Context;

import com.mcqtest.common.networkutil.NetworkUtil;
import com.mcqtest.common.view.BaseView;

public class BasePresenter {

    private BaseView mView;

    protected BasePresenter(BaseView baseView) {
        mView = baseView;
    }

    public void onDestroy() {
        mView = null;
    }

    public BaseView getView() {
        return mView;
    }

    protected boolean isNetworkAvailable(Context ctx) {
        return NetworkUtil.isAvailable(ctx);
    }

}
