package com.mygdx.game;

import java.util.List;
import java.net.URL;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

//OLIVIA/ANUHYA
public class Song
{

    private double offset;
    private double songPosition;
    private int t = Song.songPosition;//at end --- what is this for exactly?
    private int bpm;
    private double beatLength =  60/bpm;
    private String fileName; // "xxx.mp3"
    List<Note> beatmap = new List<Note>(); 

    public Song(String f, double o, int b)
    {
        offset = o;
        fileName = s;
        bpm = b;
        songPosition = (float)(AudioSettings.dspTime – dsptimesong) * bpm – offset;
    }
    
public class VLC extends Application 
{
    private void playMedia() 
    {
        URL resource = getClass().getResource(fileName);
        System.out.println(resource.toString());
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    public static void main(String args[]) {
        new VLC().playMedia();
    }
    @Override
    public void start(Stage stage) throws Exception 
    {
    }
}

    //Offset: Start time - song start;

