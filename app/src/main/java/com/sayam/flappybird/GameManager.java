package com.sayam.flappybird;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class GameManager {
    BgImage bgImage;
    FlyingBird bird;
    static int gameState;
    ArrayList<TubeCollection> tubeCollectionArrayList;
    Random random;
    int scoreCount;
    int winningCount;
    Paint designPaint;

    public GameManager() {
        bgImage = new BgImage();
        bird = new FlyingBird();
        gameState = 0;
        tubeCollectionArrayList = new ArrayList<>();
        random = new Random();
        generateTubeObject();
        inScoreValue();

    }

    private void inScoreValue() {
        scoreCount = 0;
        winningCount = 0;
        designPaint = new Paint();
        designPaint.setColor(Color.YELLOW);
        designPaint.setTextSize(250);
        designPaint.setStyle(Paint.Style.FILL);
        designPaint.setFakeBoldText(true);
        designPaint.setShadowLayer(5.1f, 20.0f, 20.0f, Color.BLACK);

    }

    public void generateTubeObject() {
        for (int j = 0; j < AppHolder.tubeGap; j++) {
            int tubeX = AppHolder.SCREEN_WIDTH_X + j * AppHolder.tubeDistance;
            int upTubeCollection_Y = AppHolder.minTubeCollection_Y;
            random.nextInt(AppHolder.maxTubeCollection_Y - AppHolder.minTubeCollection_Y + 1);
            TubeCollection collection = new TubeCollection(tubeX, upTubeCollection_Y);
            tubeCollectionArrayList.add(collection);
        }
    }

    public void scrollingTube(Canvas canvas) {
        if (gameState == 1) {

            if ((tubeCollectionArrayList.get(winningCount).getXTube() < AppHolder.getBitmapControl().getBirdWirth())
                    && (tubeCollectionArrayList.get(winningCount).getUpTubeCollectionY() > bird.getY()
                    || tubeCollectionArrayList.get(winningCount).getDownTube() < bird.getY() + AppHolder.getBitmapControl().getBirdHeight())) {
                gameState = 2;
                AppHolder.getSoundPlay().playHit();
                Context context = AppHolder.gameActivityContext;
                Intent intent = new Intent(context, GameOverActivity.class);
                intent.putExtra("score",scoreCount);
                context.startActivity(intent);
                ((Activity)context).finish();


                if (tubeCollectionArrayList.get(winningCount).getXTube() < bird.getX() -
                        AppHolder.getBitmapControl().getTubeWidth()) {
                    scoreCount++;
                    winningCount++;
                   AppHolder.getSoundPlay().playPoint();
                    if (winningCount > AppHolder.tube_numbers - 1) {
                        winningCount = 0;
                    }
                }
                for (int i = 0; i < AppHolder.tube_numbers; i++) {

                    if (tubeCollectionArrayList.get(i).getXTube() <
                            -(AppHolder.getBitmapControl().getTubeWidth())) {
                        tubeCollectionArrayList.get(i).setXTube(tubeCollectionArrayList.get(i).getXTube()
                                + AppHolder.tube_numbers * AppHolder.tubeDistance);
                        int upTubeCollection_Y = AppHolder.minTubeCollection_Y +
                                random.nextInt(AppHolder.maxTubeCollection_Y + AppHolder.minTubeCollection_Y + 1);
                        tubeCollectionArrayList.get(i).setUpTubeCollectionY(upTubeCollection_Y);
                        tubeCollectionArrayList.get(i).setColorTube();
                    }
                    tubeCollectionArrayList.get(i).setXTube(tubeCollectionArrayList.get(i).getXTube() - AppHolder.tubeVelocity);
                   if (tubeCollectionArrayList.get(i).getColorTube() == 0){
                       canvas.drawBitmap(AppHolder.getBitmapControl().getUpTube(), tubeCollectionArrayList.get(i).getXTube(),
                               tubeCollectionArrayList.get(i).getUpTube_Y(), null);

                       canvas.drawBitmap(AppHolder.getBitmapControl().getDownTube(), tubeCollectionArrayList.get(i).getXTube(),
                               tubeCollectionArrayList.get(i).getDownTube(), null);
                   }else {
                       canvas.drawBitmap(AppHolder.getBitmapControl().getUpColorTube(), tubeCollectionArrayList.get(i).getXTube(),
                               tubeCollectionArrayList.get(i).getUpTube_Y(), null);

                       canvas.drawBitmap(AppHolder.getBitmapControl().getDownColorTube(), tubeCollectionArrayList.get(i).getXTube(),
                               tubeCollectionArrayList.get(i).getDownTube(), null);
                   }
                }
                canvas.drawText("" + scoreCount, 620, 400, designPaint);
            }
        }

    }
    // Bird Anim
    public void BirdAnimation(Canvas canvas){
        if (gameState == 1) {
            if (bird.getY() < (AppHolder.SCREEN_HEIGHT_Y -
                    AppHolder.getBitmapControl().getBirdHeight()
            ) || bird.getVelocity() < 0) {
                bird.setVelocity(bird.getVelocity() + AppHolder.gravityPull);
                bird.setY(bird.getY() + bird.getVelocity());
            }
        }
        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppHolder.getBitmapControl()
                        .getBird(currentFrame), bird.getX(), bird.getY(),
                null);
        currentFrame++;
        if (currentFrame > bird.maxFrame)
            currentFrame = 0;
        else
            bird.setCurrentFrame(currentFrame);
    }
    // backgroundAnim
    public void backgroundAnimation (Canvas canvas){
        bgImage.setX(bgImage.getX() - bgImage.getVelocity());
        if (bgImage.getX() <- AppHolder.getBitmapControl().getBackgroundWirth()) {
            bgImage.setX(0);
        }
        canvas.drawBitmap(AppHolder.getBitmapControl().getBackgroundImage(), bgImage.getX(), bgImage.getY(), null);
        if (bgImage.getX() < -(AppHolder.getBitmapControl().getBackgroundWirth() - AppHolder.SCREEN_WIDTH_X)) {
            canvas.drawBitmap(AppHolder.getBitmapControl().getBackgroundImage(),
                    bgImage.getX() + AppHolder.getBitmapControl().getBackgroundWirth(), bgImage.getY(), null);
        }
    }
}
