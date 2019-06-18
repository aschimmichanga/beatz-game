package com.mygdx.game;

import java.util.ArrayList;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.utils;

//OLIVIA/ANUHYA
public class Song
{
    private String fileName; // "xxx.mp3"
    private double offset;
    private int bpm;
    private double songPosition;
    private double beatLength;
    private ArrayList<Note> beatmap;
    private Music music;

    public Song(String file, double o, int b)
    {
        fileName = file;
        offset = o;
        bpm = b;
        music = Audio.newMusic(fileName);
        songPosition = (float)(music.getPosition() / 60.0) * bpm – offset; //calcs what beat it's at out of total beats,
        // assuming pos is in seconds
        beatLength =  60.0 / bpm;
        beatmap = new ArrayList<Note>();

    }
    private String getFileName()
    {
        return fileName;
    }

    private double getSongPosition() { return songPosition; }

    private double getBeatLength() { return beatLength; }
    //finish writing the setters and getters

    private Music getMusic() {return music;}
}

    //Offset: Start time - song start;

