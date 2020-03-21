package a.childish_tales.activtiy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import a.childish_tales.R;

public class SplashActivity extends AppCompatActivity {
    private String TAG = "amingoli-splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> startActivity(new Intent(SplashActivity.this, MainActivity.class)),500);
    }

}
