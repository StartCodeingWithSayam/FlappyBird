package com.sayam.flappybird;

public class FlyingBird {
    private int birdX;
    private int birdY;
    private int currentFrame;
    private int velocity;
    public int maxFrame;

    public FlyingBird(){
        birdX = AppHolder.SCREEN_WIDTH_X/2 - AppHolder.getBitmapControl()
        .getBirdWirth()/2;
        birdY = AppHolder.SCREEN_HEIGHT_Y/2 - AppHolder.getBitmapControl()
        .getBirdHeight()/2;
        currentFrame = 0;
        maxFrame = 2;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getX() {
        return birdX;
    }
    public int getY(){
        return birdY;
    }

    public void setX(int birdX) {
        this.birdX = birdX;
    }

    public void setY(int birdY) {
        this.birdY = birdY;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

}
