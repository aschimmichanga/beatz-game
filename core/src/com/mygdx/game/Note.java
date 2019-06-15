package com.mygdx.game;
//ASHNA
  public abstract class Note
{
  private int notes; //1-4
  private double timeInSong; //what song position the note occurs at

  public Note(String notesAndTime)
  {
      //initialization
      notes = 0;
      timeInSong = 0;

      notes = Integer.parseInt(notesAndTime.substring(0, notesAndTime.indexOf(",")));
      timeInSong = calculateTime(notesAndTime.substring(notesAndTime.indexOf(",") + 1));
  }

  private double calculateTime (String time)
  {
    double calcTime = 0;

    //checking format of timing.. convert from minutes to seconds if minutes are written
    if (time.indexOf(":") != 0)
      calcTime = Integer.parseInt(time.substring(0, time.indexOf(":"))) * 60;

    timeInSong += Double.parseDouble(time.substring(time.indexOf(":") + 1));

    return calcTime;
  }

  //setters
  public void setTime(String time) { timeInSong = calculateTime(time); }

  //getters (no definition for note getter because the number of notes being return varies)
  public int getNotes() { return notes; }
  public double getTime() { return timeInSong; }
}


