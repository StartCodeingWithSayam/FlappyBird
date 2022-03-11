package com.sayam.flappybird;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.MediaStore;

public class SoundPlayer {
    Context context;
    MediaPlayer move,score,crash,jump;
    public SoundPlayer(Context context) {
        this.context = context;
        move = MediaPlayer.create(context,R.raw.swoosh);
        crash = MediaPlayer.create(context,R.raw.hit);
        jump = MediaPlayer.create(context,R.raw.wing);
        score = MediaPlayer.create(context,R.raw.point);
    }
    public void playSwoosh(){
        if (move != null)
            move.start();
    }
    public void playHit(){
        if (crash != null)
            crash.start();
    }
    public void playPoint(){
        if (score != null)
            score.start();
    }
    public void playWing(){
        if (jump != null)
            jump.start();
    }
}