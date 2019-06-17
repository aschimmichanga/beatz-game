package com.mygdx.game;

import	com.badlogic.gdx.Game;
import	com.badlogic.gdx.Gdx;
import	com.badlogic.gdx.Input.Keys;
import	com.badlogic.gdx.graphics.Color;
import	com.badlogic.gdx.graphics.Texture;
import	com.badlogic.gdx.scenes.scene2d.ui.Label;
import	com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import	com.badlogic.gdx.scenes.scene2d.actions.Actions;
import	com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.mygdx.game.utils.BaseActor;

public class StartScreen extends com.mygdx.game.utils.BaseScreen
{
    public StartScreen (Game g)
    {
        super(g);
    }

    public void create()
    {
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/soundwave.jpg")));
        uiStage.addActor(background);
        BaseActor titleText	= new BaseActor();
        titleText.setTexture( new Texture(Gdx.files.internal("assets/Title.png"))	);
        titleText.setPosition(20,100	);
        uiStage.addActor(titleText);
        BitmapFont font = new	BitmapFont();
        String text = "Press SPACE To Play";
        LabelStyle style = new	LabelStyle(font, Color.PINK);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(100, 50);

        //	repeating	color	pulse	effect
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