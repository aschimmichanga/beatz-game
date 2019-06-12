package com.mygdx.game;

import java.util.List;

//OLIVIA/ANUHYA
public class Song
{

    private double offset;
    private double songPosition;
    private int t = Song.songPosition;//at end --- what is this for exactly?
    private int bpm;
    private double beatLength =  60/bpm;
    private String songName;
    List<Note> beatmap = new List<Note>(); 

    public Song(String s, double o, int b)
    {
        offset = o;
        songname = s;
        bpm = b;
        songPosition = (float)(AudioSettings.dspTime – dsptimesong) * bpm – offset;
        
    }

}

    //Offset: Start time - song start;

