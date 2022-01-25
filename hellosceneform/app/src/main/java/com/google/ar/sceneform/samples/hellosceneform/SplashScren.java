package com.google.ar.sceneform.samples.hellosceneform;

/*
The splash screen shows the splashs screen image for 2.5 secs and starts the navigation menu.
 */

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScren extends AppCompatActivity {

    private final int DURATION_SPLASH = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_scren);

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent intent = new Intent(SplashScren.this, NavigationMenu.class);
                startActivity(intent);
                finish();
            };
        }, DURATION_SPLASH);
    }
}
