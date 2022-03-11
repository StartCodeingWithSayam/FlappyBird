package com.sayam.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapControl {
    Bitmap bg;
    Bitmap[] flyingBirds;
    Bitmap upTube;
    Bitmap downTube;
    public BitmapControl(Resources res) {
        bg = BitmapFactory.decodeResource(res, R.drawable.background);
        bg = imageScale(bg);
        flyingBirds = new Bitmap[3];
        flyingBirds[0] = BitmapFactory.decodeResource(res,R.drawable.bird_1);
        flyingBirds[1] = BitmapFactory.decodeResource(res,R.drawable.bird_2);
        flyingBirds[2] = BitmapFactory.decodeResource(res,R.drawable.bird_3);
        upTube = BitmapFactory.decodeResource(res, R.drawable.up1);
        downTube = BitmapFactory.decodeResource(res,R.drawable.down1);
    }
    public Bitmap getUpTube() {
        return upTube;
    }
    public Bitmap getDownTube() {
        return downTube;
    }
    public int getTubeWidth(){
        return upTube.getWidth();
    }
    public int gerTubeHeight(){
        return upTube.getHeight();
    }
    public Bitmap getBird(int frame) {
        return flyingBirds[frame];
    }
    public int getBirdWirth(){
        return flyingBirds[0].getWidth();
    }
    public int getBirdHeight(){
        return flyingBirds[0].getHeight();
    }
    public Bitmap getBg(){
        return bg;
    }
    public int getBackgroundWirth(){
        return bg.getWidth();
    }
    public int getBackgroundHeight(){
        return bg.getHeight();
    }
    public Bitmap imageScale(Bitmap bitmap){
        Bitmap bitmap1 = null;
        try {
            float widthHeightRatio = (float) getBackgroundWirth()
                    /getBackgroundHeight();
            int bgScaleWidth = (int)(widthHeightRatio*AppHolder.SCREEN_WIDTH_X);
            bitmap1 = Bitmap.createScaledBitmap(bitmap,bgScaleWidth
                    ,AppHolder.SCREEN_HEIGHT_Y,false);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return bitmap1;
    }
}
