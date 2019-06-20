package com.mygdx.game;

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
    public StartScreen (com.mygdx.game.utils.BaseGame g)
    {
        super(g);
    }

    public void create()
    {
        //set background of start screen
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/soundwave.jpg")));
        uiStage.addActor(background);

        //add table (formatting everything like CSS)
        Table t = new Table();
        t.setFillParent(true);

        //add title text to start screen
        BaseActor titleText	= new BaseActor();
        titleText.setTexture( new Texture(Gdx.files.internal("assets/Title.png"))	);
        t.add(titleText);

        //add instructions on how to start to start screen
        BitmapFont font = new	BitmapFont();
        String text = "Press SPACE To Play";
        LabelStyle style = new	LabelStyle(font, Color.PINK);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(100, 50);

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