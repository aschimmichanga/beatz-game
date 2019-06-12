package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class StartingScreen extends Game {
    private SpriteBatch batch;
    private Sprite titleSprite;
    private Sprite speakerSprite;
    private Sprite floorSprite;
    private Sprite winTextSprite;
    private boolean win;

    public void create()
    {
        batch = new SpriteBatch();

        titleSprite = new Sprite( new Texture(Gdx.files.internal("title.png")) );
        titleSprite.setPosition( 100, 100 );
        speakerSprite = new Sprite( new Texture(Gdx.files.internal("speaker.png")) );
        speakerSprite.setPosition( 0, 400 );

        floorSprite = new Sprite( new Texture(Gdx.files.internal("tiles.jpg")) );
        floorSprite.setPosition( 0, 0 );
        winTextSprite = new Sprite( new Texture(Gdx.files.internal("you-win.png")) );
        winTextSprite.setPosition( 140, 80 );
        win = false;
    }

    public void render()
    {
        // process input
        if (Gdx.input.isKeyPressed(Keys.LEFT))
            titleSprite.translateX( -1 );
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            titleSprite.translateX( 1 );
        if (Gdx.input.isKeyPressed(Keys.UP))
            titleSprite.translateY( 1 );
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            titleSprite.translateY( -1 );

        // check win condition
        Rectangle cheeseRectangle = speakerSprite.getBoundingRectangle();
        Rectangle mouseyRectangle = titleSprite.getBoundingRectangle();
        if ( cheeseRectangle.contains(mouseyRectangle) )
            win = true;
        //draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        floorSprite.draw( batch );
        speakerSprite.draw( batch );
        titleSprite.draw( batch );
        if (win)
            winTextSprite.draw( batch );
        batch.end();
    }
}
