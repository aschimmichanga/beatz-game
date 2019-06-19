package com.mygdx.game.tester;

//ANUHYA / ASHNA

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class ScorestreaksTester implements ApplicationListener {

    private double timeElapsed;
    private int scoreValue = 0; //temporary... score should be global system wide
    private int perfect = 0;
    private int good = 0;
    private int miss = 0;

    public void create()
    {
        //TODO: put a listener here for pressing SPACE to set arrival time
        //TODO: put a log print statement here for printing the note info and setting the note time

        //timeElapsed = arrivalTime - noteTime;a

        if(timeElapsed <= 0.100)
        {
            perfect++;
            Gdx.app.log("Scorestreak","Perfect!");
            scoreValue += 10;
        }
        else if (timeElapsed <= 0.250)
        {
            good++;
            Gdx.app.log("Scorestreak","Good");
            scoreValue += 10;
        }
        else if (timeElapsed > .250)
        {
            miss++;
            Gdx.app.log("Scorestreak","Miss :(");
        }

        //score-streaks
        if (perfect == 5 )//change, so that the score multiplies on correct intervals.
            scoreValue *=2;
        else if(perfect == 10)
            scoreValue *= 5;
        else if (perfect == 15)
            scoreValue *= 10;
    }

    @Override
    public void dispose() { }

    private void update(){ }

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
