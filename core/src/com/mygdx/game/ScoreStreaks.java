package com.mygdx.game;

//ANUHYA / ASHNA

public class ScoreStreaks {

    private double timeElapsed;
    private int scoreValue = 0; //temporary... score should be global system wide
    private int perfect = 0;
    private int good = 0;
    private int miss = 0;

    public ScoreStreaks(double arrivalTime, double noteTime)
    {
        timeElapsed = arrivalTime - noteTime;

        if(timeElapsed <= 0.100)
        {
            perfect++;
            System.out.println("Perfect!");
            scoreValue += 10;
        }
        else if (timeElapsed <= 0.250)
        {
            good++;
            System.out.println("Good");
            scoreValue += 10;
        }
        else if (timeElapsed > .250)
        {
            miss++;
            System.out.println("Miss :(");
        }

        //score-streaks
        if (perfect == 5 )//change, so that the score multiplies on correct intervals.
            scoreValue *=2;
        else if(perfect == 10)
            scoreValue *= 5;
        else if (perfect == 15)
            scoreValue *= 10;
    }

    //setters
    public void setTimeElapsed(double newTime) {timeElapsed = newTime;}
    public void setScoreValue (int newScore) {scoreValue = newScore;}
    public void setPerfect (int newPerfect) {perfect = newPerfect;}
    public void setGood (int newGood) {good = newGood;}
    public void setMiss (int newMiss) {miss = newMiss;}

    //getters
    public double getTimeElapsed() {return timeElapsed;}
    public int getScoreValue () {return scoreValue;}
    public int getPerfect () {return perfect;}
    public int getGood () {return good;}
    public int getMiss () {return miss;}
}
