package com.mygdx.game;

import com.badlogic.gdx.Game;
import	com.badlogic.gdx.Gdx;
import	com.badlogic.gdx.Input.Keys;
import	com.badlogic.gdx.graphics.Color;
import	com.badlogic.gdx.graphics.Texture;
import	com.badlogic.gdx.scenes.scene2d.ui.Label;
import	com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import	com.badlogic.gdx.scenes.scene2d.actions.Actions;
import	com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.utils.BaseActor;

//ASHNA

public class StartScreen extends com.mygdx.game.utils.BaseScreen
{
    public StartScreen (Game g)
    {
        super(g);
    }

    public void create()
    {
        //set background of start screen
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("Soundwave.jpg")));
        background.setPosition(0,0);
        uiStage.addActor(background);

        //add title text to start screen
        BaseActor titleText	= new BaseActor();
        titleText.setTexture( new Texture(Gdx.files.internal("BeatzLogo.png")));
        titleText.setPosition(240,25);
        uiStage.addActor(titleText);

        //add decorative music notes to start screen
        BaseActor blueNote	= new BaseActor();
        blueNote.setTexture( new Texture(Gdx.files.internal("BlueNote.png")));
        blueNote.setPosition(96,336);
        uiStage.addActor(blueNote);

        BaseActor purpleNote	= new BaseActor();
        purpleNote.setTexture( new Texture(Gdx.files.internal("PurpleNote.png")));
        purpleNote.setPosition(410,600);
        uiStage.addActor(purpleNote);

        BaseActor pinkNote	= new BaseActor();
        pinkNote.setTexture( new Texture(Gdx.files.internal("PinkNote.png")));
        pinkNote.setPosition(740,336);
        uiStage.addActor(pinkNote);

        //adding decorative piano above instructions
        BaseActor piano	= new BaseActor();
        piano.setTexture( new Texture(Gdx.files.internal("Piano.png")));
        piano.setPosition(950,200);
        uiStage.addActor(piano);

        //adding decorative harp above instructions
        BaseActor harp	= new BaseActor();
        harp.setTexture( new Texture(Gdx.files.internal("Harp.png")));
        harp.setPosition(1100,100);
        uiStage.addActor(harp);

        //add instructions on how to start to start screen
        BitmapFont font = new	BitmapFont();
        String text = "Press SPACE To Play";
        LabelStyle style = new	LabelStyle(font, Color.PINK);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(900, 50);

        //	repeating	color	pulse	effect for instructions
        instructions.addAction(Actions.forever(Actions.sequence(Actions.color(	new	Color(1,1,0,1),	0.5f),
                Actions.delay(0.5f),
                Actions.color(new Color(0.5f, 0.5f, 0, 1),	0.5f))));
        uiStage.addActor(instructions);
    }

    public void update(float dt) { } //	InputProcessor	methods	for	handling	discrete	input

    public boolean keyDown(int keycode)
    {
        if	(keycode ==	Keys.SPACE)
        {
            game.setScreen(	new	Menu(game));
            return true;
        }
        return	false;
    }
}