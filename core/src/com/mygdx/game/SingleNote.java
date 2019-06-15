package com.mygdx.game;

//ASHNA

public class SingleNote extends Note
{
    public SingleNote(String noteAndTime)
    {
        super(noteAndTime);
    }

    //getters (to avoid errors from confusion)
    public int getNote() { return getNotes();}
}
