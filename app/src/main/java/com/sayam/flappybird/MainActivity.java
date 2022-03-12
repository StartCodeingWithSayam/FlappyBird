package com.sayam.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnImg;
    Button rate,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnImg = findViewById(R.id.imageBtn);
        rate = findViewById(R.id.rate);
        exit = findViewById(R.id.exit);
        AppHolder.assign(MainActivity.this);

        btnImg.setOnClickListener(view -> {
            Intent intent = new Intent(this,GameActivity.class);
            startActivity(intent);
            finish();
        });

        exit.setOnClickListener(view -> {
            finish();
            System.exit(0);
        });
    }
}