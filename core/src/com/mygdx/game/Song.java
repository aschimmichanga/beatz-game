package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

//ASHNA/OLIVIA/ANUHYA
public class Song
{
    private String fileName; // "xxx.mp3"
    private float offset;
    private int bpm;
    private float songPosition;
    private float beatLength;
    private ArrayList<Note> beatmap;
    private Music music;

    public Song(String file, float offSet, int beatsPerMin)
    {
        fileName = file;
        offset = offSet;
        bpm = beatsPerMin;

        music = Gdx.audio.newMusic(Gdx.files.internal(fileName));

        //calculate what beat it's at out of total beats, assuming pos is in seconds
        songPosition = music.getPosition() / 60.0f * bpm - offset;

        beatLength =  60.0f / bpm;
        beatmap = new ArrayList<Note>();

    }

    //getters
    public String getFileName()
    {
        return fileName;
    }
    public float getSongPosition() { return songPosition; }
    public float getBeatLength() { return beatLength; }
    public Music getMusic() {return music;}
}

    //Offset: Start time - song start;

    //LISSAN - Song Objects (made offset 0 to fill in the gaps since we no longer need it):
    //Song firstSong = new Song("ElectroSurge.mp3", 0, 128);
    //Song secondSong = new Song("Jackson 5 - I Want You Back.mp3", 0, 98);

