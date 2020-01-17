package com.example.metapall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splashscreen extends AppCompatActivity {

    private ImageView imageView;
    private ImageView imageView2;

    private static int splashTimeOut=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splashscreen.this,BMRActivity.class);
                startActivity(i);
                finish();
            }
        },splashTimeOut);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.fade);
        imageView.startAnimation(myanim);
        imageView2.startAnimation(myanim);
    }
    }
