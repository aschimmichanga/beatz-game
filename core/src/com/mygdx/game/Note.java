package com.mygdx.game;
//ASHNA

import com.mygdx.game.utils.BaseActor;

public class Note extends BaseActor {
  private int firstNote;
  private int secondNote;
  private double timeInSong; //what song position the note occurs at

  //x positions of each note TODO
  final int initX1 = 0;
  final int initX2 = 0;
  final int initX3 = 0;
  final int initX4 = 0;

  public Note(String notesAndTime) {
    //initialization
    firstNote = 0;
    //single note: note1,time,
    secondNote = 0;
    timeInSong = 0;

    //file formatting template for reference:
    //double note: note1note2,time,
    int tempNotes = Integer.parseInt(notesAndTime.substring(0, notesAndTime.indexOf(",")));
    if (tempNotes > 4) {
      firstNote = tempNotes / 10;
      secondNote = tempNotes % 10;
    }
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

  public void setFirstNote(int first) {
    firstNote = first;
  }

  public void setSecondNote(int second) {
    secondNote = second;
  }


  //getters
  public double getTime() {
    return timeInSong;
  }
-
  public int getFirstNote() {
    return firstNote;
  }

  public int getSecondNote() {
    return secondNote;
    //check if it's a single note or not by checking if getSecondNote() returns 0
  }
}


