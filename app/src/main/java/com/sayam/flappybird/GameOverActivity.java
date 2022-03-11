package com.sayam.flappybird;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    TextView bestDisplay,ScoreDisplay;
    Button restart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        bestDisplay = findViewById(R.id.bestDisplay);
        ScoreDisplay = findViewById(R.id.scoreDisplay);
        restart = findViewById(R.id.restart);
        int scoreCount = getIntent().getExtras().getInt("score");
        SharedPreferences pref = getSharedPreferences("my StoragePreferences",0);
        int scoreBest = pref.getInt("scoreBest",0);
        SharedPreferences.Editor editor = pref.edit();
        if (scoreCount > scoreBest){
            scoreBest = scoreCount;
            editor.putInt("scoreBest",scoreBest);
            editor.apply();
        }
        restart.setOnClickListener(view -> {
            Intent i = new Intent(GameOverActivity.this,MainActivity.class);
            startActivity(i);

        });
        ScoreDisplay.setText(scoreCount);
        bestDisplay.setText(scoreBest);
    }
}