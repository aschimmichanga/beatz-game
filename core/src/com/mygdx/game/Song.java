package com.mygdx.game;

import java.util.List;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

//OLIVIA/ANUHYA
public class Song
{

    private double offset;
    private double songPosition;
    private int t = Song.songPosition;//at end --- what is this for exactly?
    private int bpm;
    private double beatLength =  60/bpm;
    private String songName; // "xxx.mp3"
    List<Note> beatmap = new List<Note>(); 

    public Song(String s, double o, int b)
    {
        offset = o;
        songName = s;
        bpm = b;
        songPosition = (float)(AudioSettings.dspTime – dsptimesong) * bpm – offset;
    }
    
   Media hit = new Media(new File(songName).toURI().toString());
   MediaPlayer mediaPlayer = new MediaPlayer(hit);
   mediaPlayer.play();
}

    //Offset: Start time - song start;

