package com.mygdx.game;

public class Scorestreaks {

    private int timeElapsed;
    private int scoreValue = 0;
    private int perfect = 0;
    private int good = 0;
    private int miss = 0;

    public ScoreStreaks()
    {
        timeElapsed = timeArrived - timeHit;

        if(timeElapsed <= 0.2500)
        {
            perfect++;
            System.out.println("perfect!");
            scoreValue += 10;
        }
    }

}
