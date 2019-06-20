package com.mygdx.game.tester;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.mygdx.game.Song;

//OLIVIA/ASHNA

public class SongPosTester  implements ApplicationListener
{
    private Song x;

    public void create()
    {
        x = new Song("ElectroSurge.mp3", 0, 128, 0.470f);
        boolean playing;

        x.getMusic().play();
        playing = x.getMusic().isPlaying();
        // System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        x.getMusic().pause();
        playing = x.getMusic().isPlaying();
//        System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        x.getMusic().play();
        playing = x.getMusic().isPlaying();
//        System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        while (x.getMusic().isPlaying()) {
            if (x.getMusic().getPosition() == 13.2f) {
                //System.out.println(x.getMusic().getPosition()); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                //System.out.println(x.getSongPosition()); //time elapsed with Song. bottom line should be top line * bpm
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 30.366f) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 60.1f) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 90.233f) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 120.9f) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 300f) //not supposed to work
            {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
        }
    }

    @Override
    public void dispose() {
        x.getMusic().dispose();
    }

    private void update(){ }

    @Override
    public void render() {
        x.getMusic().play();
        update();}

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }
}
