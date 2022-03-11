package com.sayam.flappybird;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    final SurfaceHolder holder;
    long timeSpent;
    long kickOfTime;
    long WAIT = 30;
    boolean running;
    private static Canvas canvas;
    public MainThread(SurfaceHolder holder) {
        this.holder = holder;
        running = true;

    }

    @Override
    public void run() {
        while (running){
            kickOfTime = SystemClock.uptimeMillis();
            canvas = null;
            try{

                synchronized (holder) {
                    canvas = holder.lockCanvas();
                    AppHolder.getGameManager().backgroundAnimation(canvas);
                    AppHolder.getGameManager().BirdAnimation(canvas);
                    AppHolder.getGameManager().scrollingTube(canvas);

                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                if (canvas != null){
                      try{
                         holder.unlockCanvasAndPost(canvas);
                      }catch (Exception e){
                          e.printStackTrace();
                      }
                }
            }
            timeSpent = SystemClock.uptimeMillis() - kickOfTime;
            if (timeSpent<WAIT){
                try {
                    Thread.sleep(WAIT-timeSpent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isRunning(){
        return running;
    }
    public void setIsRunning(boolean b) {
        running = b;
    }
}