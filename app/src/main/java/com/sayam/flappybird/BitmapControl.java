package com.sayam.flappybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapControl {
    Bitmap backgroundImage = null;
    Bitmap[] flyingBirds;
    Bitmap upTube;
    Bitmap downTube;
    Bitmap upColorTube,downColorTube;
    Bitmap UpColorTube,DownColorTube;
    public BitmapControl(Resources res) {
        backgroundImage = BitmapFactory.decodeResource(res, R.drawable.bg);
        backgroundImage = imageScale(backgroundImage);
        flyingBirds = new Bitmap[3];
        flyingBirds[0] = BitmapFactory.decodeResource(res,R.drawable.bird_1);
        flyingBirds[1] = BitmapFactory.decodeResource(res,R.drawable.bird_2);
        flyingBirds[2] = BitmapFactory.decodeResource(res,R.drawable.bird_3);
        upTube = BitmapFactory.decodeResource(res, R.drawable.up1);
        downTube = BitmapFactory.decodeResource(res,R.drawable.down1);
        upColorTube = BitmapFactory.decodeResource(res,R.drawable.up2);
        downColorTube = BitmapFactory.decodeResource(res,R.drawable.down2);
        UpColorTube = BitmapFactory.decodeResource(res,R.drawable.up3);
        DownColorTube = BitmapFactory.decodeResource(res,R.drawable.down3);
    }

    public Bitmap getUpColorTube() {
        return upColorTube;
    }

    public Bitmap getUpTube() {
        return upTube;
    }

    public Bitmap getDownColorTube() {
        return downColorTube;
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
    public Bitmap getBackgroundImage(){
        return backgroundImage;
    }
    public float getBackgroundWirth(){
        return backgroundImage.getWidth();
    }
    public float getBackgroundHeight(){
        return backgroundImage.getHeight();
    }
    public Bitmap imageScale(Bitmap bitmap){
        Bitmap bitmap1;
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
