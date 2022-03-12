package com.sayam.flappybird;

import java.util.Random;

public class TubeCollection {
    private int xTube;
    private int upTubeCollectionY;
    private final Random random;
    private int colorTube;
    // constructor
    public TubeCollection(int xTube, int upTubeCollectionY) {
        this.xTube = xTube;
        this.upTubeCollectionY = upTubeCollectionY;
        random = new Random();
    }
    // getters
    public int getXTube() {
        return xTube;
    }
    public int getColorTube(){
        return colorTube;
    }
    public int getUpTubeCollectionY() {
        return upTubeCollectionY;
    }
    public int getUpTube_Y(){
        return upTubeCollectionY - AppHolder.getBitmapControl().gerTubeHeight();
    }
    public int getDownTube(){
        return upTubeCollectionY + AppHolder.   tubeGap;
    }
    // setters
    public void setXTube(int xTube) {
        this.xTube = xTube;
    }

    public void setUpTubeCollectionY(int upTubeCollectionY) {
        this.upTubeCollectionY = upTubeCollectionY ;
    }
    public void setColorTube(){
        colorTube = random.nextInt(2);

    }
}
