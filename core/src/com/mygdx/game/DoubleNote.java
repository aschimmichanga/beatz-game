package com.mygdx.game;

public class DoubleNote extends Note
{
    private int firstNote;
    private int secondNote;
    public DoubleNote(String notesAndTime)
    {
        super(notesAndTime);
        firstNote = getNotes() / 10;
        secondNote = getNotes() % 10;
    }

    //setters
    public void setFirstNote(int first) {firstNote = first;}
    public void setSecondNote(int second) {secondNote = second;}

    //getters
    public int getFirstNote(){return firstNote;}
    public int getSecondNote() {return secondNote;}
}
