package com.codefun.common.util;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.webkit.SslErrorHandler;

import com.codefun.R;

public class DialogUtil {

    public static void showWebViewSslErrorDialog(Activity activity, SslErrorHandler handler) {
        if (activity == null) {
            return;
        }
        AlertDialog dialog = new AlertDialog.Builder(activity)
                .setMessage(R.string.ssl_certificate_invalid)
                .setPositiveButton("Continue", (dialog1, which) -> handler.proceed())
                .setNegativeButton("Cancel", (dialog1, which) -> handler.cancel()).create();
        dialog.setCancelable(false);
        if (!activity.isFinishing()) {
            dialog.show();
        }
    }
}
