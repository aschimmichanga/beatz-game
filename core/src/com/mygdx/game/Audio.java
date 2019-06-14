package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;



public class Audio implements ApplicationListener
{
    private Sound music;
    public void create()
    {
        music = Gdx.audio.newSound(Gdx.files.internal("ElectroSurge.mp3"));
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
        music.play(0.5f);


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
