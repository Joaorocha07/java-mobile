package com.example.applistadetarefas.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.applistadetarefas.R;
import com.example.applistadetarefas.database.TarefasDB;

public class SplashActivity extends AppCompatActivity {
    public static final int TIME_OUT_SPLASH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        cumutarTelaSplash();
    }

    private void cumutarTelaSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TarefasDB db = new TarefasDB(SplashActivity.this);
                Intent telaPrincipal = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(telaPrincipal);
                finish();
            }
        }, TIME_OUT_SPLASH);
    }
}
