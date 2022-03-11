package com.sayam.flappybird;

import java.util.Random;

public class TubeCollection {
    private int xTube;
    private int upTubeCollectionY;
    private Random random;
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
    public int getUpTubeCollectionY() {
        return upTubeCollectionY;
    }
    public int getUpTube(){
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
}
