package com.mygdx.game.tester;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class SpriteTest extends Game {
    private SpriteBatch batch;
    private Sprite mouseySprite;
    private Sprite cheeseSprite;
    private Sprite floorSprite;
    private Sprite winTextSprite;
    private boolean win;

    public void create()
    {
        batch = new SpriteBatch();

        //creating and placing (previously) mouse sprite, now is guitar sprite
        mouseySprite = new Sprite( new Texture(Gdx.files.internal("guitar.png")) );
        mouseySprite.setPosition( 20, 20 );

        //creating and placing (previously) cheese sprite, now is sound sprite
        cheeseSprite = new Sprite( new Texture(Gdx.files.internal("Sound.png")) );
        cheeseSprite.setPosition( 400, 300 );

        //creating and placing background
        floorSprite = new Sprite( new Texture(Gdx.files.internal("Soundwave.jpg")) );
        floorSprite.setPosition( 0, 0 );

        //creating and placing text that shows up when you "win" AKA the mouse touches the cheese
        winTextSprite = new Sprite( new Texture(Gdx.files.internal("Beatz-Logo.png")) );
        winTextSprite.setPosition( 140, 80 );
        win = false;
    }

    public void render()
    {
        // process input
        if (Gdx.input.isKeyPressed(Keys.LEFT))
            mouseySprite.translateX( -1 );
        if (Gdx.input.isKeyPressed(Keys.RIGHT))
            mouseySprite.translateX( 1 );
        if (Gdx.input.isKeyPressed(Keys.UP))
            mouseySprite.translateY( 1 );
        if (Gdx.input.isKeyPressed(Keys.DOWN))
            mouseySprite.translateY( -1 );

        // check win condition
        Rectangle cheeseRectangle = cheeseSprite.getBoundingRectangle();
        Rectangle mouseyRectangle = mouseySprite.getBoundingRectangle();
        if ( cheeseRectangle.contains(mouseyRectangle) )
            win = true;

        //draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        floorSprite.draw( batch );
        cheeseSprite.draw( batch );
        mouseySprite.draw( batch );
        if (win)
            winTextSprite.draw( batch ); //not drawn until the game is won

        batch.end();
    }
}
