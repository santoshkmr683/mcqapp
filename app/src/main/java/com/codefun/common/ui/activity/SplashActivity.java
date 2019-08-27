package com.codefun.common.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.codefun.R;
import com.codefun.news.ui.activity.NewsFeedActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView lombardLogo = findViewById(R.id.image_logo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_from_top);
        lombardLogo.startAnimation(animation);
        launchHomeActivity();
    }

    private void launchHomeActivity() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, NewsFeedActivity.class));
                finish();
            }
        }, 1500);
    }

}
