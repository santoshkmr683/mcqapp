package com.mcqtest.common.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.mcqtest.R;

public class FragmentHelper {

    /**
     * Replaces fragment without adding it to the back stack .
     */
    public static void replaceFragment(FragmentActivity activity, Fragment fragment,
                                       int containerId) {
        if (!activity.isFinishing()) {
            FragmentManager manager = activity.getSupportFragmentManager();
            manager.beginTransaction().replace(containerId, fragment).commitAllowingStateLoss();

        }
    }

    /**
     * adds the fragment to the back stack.
     */
    public static void addFragment(FragmentActivity activity, Fragment fragment, int containerId) {
        if (activity != null && !activity.isFinishing()) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_out_left, R.anim.anim_slide_out_right, R.anim.anim_slide_in_right);
            transaction.add(containerId, fragment);
            transaction.addToBackStack(null);
            transaction.commitAllowingStateLoss();
        }
    }
}
