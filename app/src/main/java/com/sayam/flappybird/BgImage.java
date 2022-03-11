package com.sayam.flappybird;

public class BgImage {
    private int image_X_Background;
    private int image_Y_Background;
    private int backgroundSpeed;

    public BgImage() {
        image_X_Background = 0;
        image_Y_Background = 0;
        backgroundSpeed = 4;
    }
    public int getX(){
        return image_X_Background;
    }
    public int getY(){
        return image_Y_Background;
    }

    public void setX(int background) {
        this.image_X_Background = background;
    }
    public void setY(int background) {
        this.image_Y_Background = background;
    }
    public int getVelocity(){
        return backgroundSpeed;
    }
}
