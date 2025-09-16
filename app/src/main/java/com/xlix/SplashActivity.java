package com.xlix;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Ambil logo
        ImageView logo = findViewById(R.id.splash_logo);

        // Animasi zoom in-out
        ScaleAnimation zoom = new ScaleAnimation(
                0.8f, 1.2f, // scale X
                0.8f, 1.2f, // scale Y
                Animation.RELATIVE_TO_SELF, 0.5f, // pivot X tengah
                Animation.RELATIVE_TO_SELF, 0.5f  // pivot Y tengah
        );
        zoom.setDuration(1000); // 1 detik
        zoom.setRepeatCount(1); // ulang sekali
        zoom.setRepeatMode(Animation.REVERSE);

        logo.startAnimation(zoom);

        // Delay lalu pindah ke MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Splash tidak bisa di-back
        }, SPLASH_DELAY);
    }
}
