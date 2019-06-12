package com.mygdx.game;

public class VLC  extends Application
{
    private void playMedia()
    {
        URL resource = getClass().getResource(Song.getfileName());
        System.out.println(resource.toString());
        Media media = new Media(resource.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        System.out.println("Playing...");
    }
    public static void main(String args[]) {
        new VLC().playMedia();
    }
    @Override
    public void start(Stage stage) throws Exception
    {
    }
}