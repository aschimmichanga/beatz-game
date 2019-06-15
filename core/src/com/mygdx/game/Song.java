package com.mygdx.game;

import java.util.ArrayList;

//OLIVIA/ANUHYA
public class Song
{
    //DO NOT SET INITIAL VALUES OUTSIDE OF THE CONSTRUCTOR!!!!!!
    private String fileName; // "xxx.mp3"
    private double offset;
    private int bpm;
    private double time;
    private double songPosition;
    private double beatLength;
    private ArrayList<Note> beatmap;

    //please use descriptive variables... f, o, and b stand for fall out boy to me
    //keep everything in the same order... ugly code drives people insane
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

