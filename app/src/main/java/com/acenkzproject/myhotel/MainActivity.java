package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        new Handler().postDelayed(() -> {
            Intent main = new Intent (MainActivity.this, LoginActivity.class);
            startActivity(main);
            finish();
            }, 3000);
    }
}