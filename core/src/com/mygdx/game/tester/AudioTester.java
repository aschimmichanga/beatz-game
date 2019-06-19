package com.mygdx.game.tester;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;


//ASHNA

public class AudioTester implements ApplicationListener
{
    private Music music;

    public void create()
    {
        music = Gdx.audio.newMusic(Gdx.files.internal("ElectroSurge.mp3"));
        music.play();
    }

    @Override
    public void dispose()
    {
        music.dispose();
    }

    private void update(){}

    @Override
    public void render()
    {
        music.play();


        update();
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

}
