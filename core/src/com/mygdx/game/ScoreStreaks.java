package com.mygdx.game;

public class ScoreStreaks {

    private int timeElapsed;
    private int scoreValue = 0;
    private int perfect = 0;
    private int good = 0;
    private int miss = 0;

    public ScoreStreaks()
    {
        timeElapsed = timeArrived - timeHit;

        if(timeElapsed <= 0.100)
        {
            perfect++;
            System.out.println("perfect!");
            scoreValue += 10;
        }
        else if(timeElapsed <=0.250)
        {
            good++;
            System.out.println("Good");
            scoreValue += 10;
         }
        else if (timeElapsed > .250)
        {
            miss++;
            System.out.println("Miss. You weeb :(");
        }

        //score-streaks
        if (perfect == 5 )//change, so that the score multiplies on correct intervals.
            scorevalue *=2;
        else if(perect == 10)
            scorevalue *= 5;
        else if (perfect == 15)
            scoreValue *= 10;
    }
    }

}
