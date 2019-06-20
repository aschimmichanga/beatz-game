package com.mygdx.game;
//ASHNA

import com.mygdx.game.utils.BaseActor;
import com.mygdx.game.utils.PhysicsActor;

public class Note extends PhysicsActor {
  private int note;
  private double timeInSong; //what song position the note occurs at

  //x positions of each note TODO
  public static final int X1 = 256;
  public static final int X2 = 416;
  public static final int X3 = 576;
  public static final int X4 = 736;

  public static final int startingHeight = 466;

  public Note(String notesAndTime) {
    //txt file formatting template for reference:
    //note,time,
    
    note = Integer.parseInt(notesAndTime.substring(0, notesAndTime.indexOf(",")));
    timeInSong = calculateTime(notesAndTime.substring(notesAndTime.indexOf(",") + 1));
  }

  private double calculateTime(String time) {
    double calcTime = 0;

    //checking format of timing.. convert from minutes to seconds if minutes are written
    if (time.indexOf(":") != 0)
      calcTime = Integer.parseInt(time.substring(0, time.indexOf(":"))) * 60;

    timeInSong += Double.parseDouble(time.substring(time.indexOf(":") + 1));

    return calcTime;
  }

  //setters
  public void setTime(String time) {
    timeInSong = calculateTime(time);
  }

  public void setNote(int n) {
    note = n;
  }


  //getters
  public double getTime() {
    return timeInSong;
  }

  public int getNote() {
    return note;
  }
}


