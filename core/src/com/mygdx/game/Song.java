package com.mygdx.game;

import java.util.ArrayList;

//OLIVIA/ANUHYA
public class Song
{
    private String fileName; // "xxx.mp3"
    private double offset;
    private int bpm;
    private double time;
    private double songPosition;
    private double beatLength;
    private ArrayList<Note> beatmap;

    public Song(String file, double o, int b)
    {
        fileName = file;
        offset = o;
        bpm = b;
        time = songPosition;//at end --- what is this for exactly?
        songPosition = ((float)(AudioSettings.dspTime) – dsptimesong) * bpm – offset;
        beatLength =  60.0 / bpm;
        beatmap = new ArrayList<Note>();

    }
    private String getFileName()
    {
        return fileName;
    }
    //finish writing the setters and getters
}

    //Offset: Start time - song start;

