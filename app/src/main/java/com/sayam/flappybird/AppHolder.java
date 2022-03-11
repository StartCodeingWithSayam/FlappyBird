package com.sayam.flappybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public class AppHolder {
    static BitmapControl bitmapControl;
    static GameManager gameManager;
    static int SCREEN_WIDTH_X;
    static int SCREEN_HEIGHT_Y;
    static int gravityPull;
    static int JUMP_VELOCITY;
    static int tubeGap;
    static int tube_numbers;
    static int tubeVelocity;
    static int minTubeCollection_Y;
    static int maxTubeCollection_Y;
    static int tubeDistance;
    public static Context gameActivityContext;
    static SoundPlayer soundPlayer;
    public static void holdGameVariable(){
        AppHolder.gravityPull = 5;
        AppHolder.JUMP_VELOCITY = -50;
        AppHolder.tubeGap = 640;
        AppHolder.tube_numbers = 2;
        AppHolder.tubeVelocity = 24;
        AppHolder.minTubeCollection_Y =(int)(AppHolder.tubeGap/2.0);
        AppHolder.maxTubeCollection_Y = AppHolder.SCREEN_HEIGHT_Y - AppHolder.minTubeCollection_Y
                - AppHolder.tubeGap;
        AppHolder.tubeDistance = AppHolder.SCREEN_WIDTH_X*2/3;

    }
    public static void assign(@NonNull Context context){
        bitmapControl = new BitmapControl(context.getResources());
        gameManager = new GameManager();
        holdGameVariable();
        mapScreenSize(context);
        soundPlayer = new SoundPlayer(context);
    }
    public static SoundPlayer getSoundPlay(){
        return soundPlayer;
    }


    public static BitmapControl getBitmapControl() {
        return bitmapControl;
    }


    public static GameManager getGameManager() {
        return gameManager;
    }

    private static void mapScreenSize(@NonNull Context context){
        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppHolder.SCREEN_WIDTH_X = width;
        AppHolder.SCREEN_HEIGHT_Y = height;

    }
}
