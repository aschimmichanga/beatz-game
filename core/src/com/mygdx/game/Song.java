package com.mygdx.game;

import java.util.List;

//OLIVIA/ANUHYA
public class Song
{

    private int offset;
    private songPosition;
    private int t = Song.songPosition;//at end
    private int bpm = t/60;
    private int beatLength =  60/bpm;
    List<Note> beatmap = new List<Note>();

    public Song()
    {
        offset = .2f;
        songPosition = (float)(AudioSettings.dspTime – dsptimesong) * song.pitch – offset;
    }

}

    //Offset: Start time - song start;

