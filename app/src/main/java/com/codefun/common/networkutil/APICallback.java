package com.codefun.common.networkutil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class APICallback<T> implements Callback<T> {

    private Context mContext;

    protected APICallback(Context context) {
        mContext = context;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            onResponseSuccess(response.body());
        } else if (response.code() == 401 || response.code() == 403) {
            onResponseFailure(response.message());
            Toast.makeText(mContext, "Server unavailable... please try after some time",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onResponseFailure(t.getMessage());
    }

    public abstract void onResponseSuccess(T response);

    public abstract void onResponseFailure(String errorMessage);
}
