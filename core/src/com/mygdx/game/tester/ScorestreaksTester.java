package com.mygdx.game.tester;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.Song;

//ASHNA

public class ScorestreaksTester implements ApplicationListener {

    private double startTime;
    private int scoreValue = 0;
    private int perfect = 0;
    private int good = 0;
    private int miss = 0;
    private Song song;

    public void create()
    {
        song = new Song("ElectroSurge.mp3", 0, 128, 0.470f);



        startTime = System.currentTimeMillis();
    }

    @Override
    public void dispose() { }

    private void update(){
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            double timeElapsed = System.currentTimeMillis() - startTime;
            Gdx.app.log("InputTime","Time Pressed: " + timeElapsed + " seconds\n");

            if(timeElapsed < 0.100)
            {
                perfect++;
                Gdx.app.log("Scorestreak","Perfect!");
                scoreValue += 500;
            }
            else if (timeElapsed < 0.250)
            {
                good++;
                Gdx.app.log("Scorestreak","Good");
                scoreValue += 250;
            }
            else
            {
                miss++;
                Gdx.app.log("Scorestreak","Miss :(");
            }

            Gdx.app.log("Scores",
                    "Score: " + scoreValue + "Perfect: " + perfect + "\nGood: " + good + "\nMiss: " + miss);
        }



    }

    @Override
    public void render() {
        update();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }
}
