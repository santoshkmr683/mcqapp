package com.codefun.common.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.codefun.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageView lombardLogo = findViewById(R.id.image_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_from_top);
        lombardLogo.startAnimation(animation);
        launchHomeActivity();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    private void launchHomeActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, 1500);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
