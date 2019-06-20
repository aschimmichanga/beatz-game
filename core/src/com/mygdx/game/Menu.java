package com.mygdx.game;

import com.badlogic.gdx.Game;
import	com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import	com.badlogic.gdx.graphics.Color;
import	com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import	com.badlogic.gdx.scenes.scene2d.ui.Label;
import	com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import	com.badlogic.gdx.scenes.scene2d.actions.Actions;
import	com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.utils.BaseActor;

//ASHNA

public class Menu extends com.mygdx.game.utils.BaseScreen
{
    public Menu (Game g)
    {
        super(g);
    }

    public void create()
    {
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("Soundwave.jpg")));
        background.setPosition(0,0);
        uiStage.addActor(background);

        BaseActor poptart = new BaseActor();
        poptart.setTexture(new Texture(Gdx.files.internal("The Most Important Sprite of All, Top Priority Sprite, Urgent Delivery.png")));
        poptart.setPosition(500,500);
        uiStage.addActor(poptart);

        //add instructions on how to start to start screen

        BitmapFont font = new	BitmapFont();
        String text = "Press \'S\' To Play Surge By Electro " +
                      "\nPress \'W\' To Play Want You Back By Jackson5" +
                      "\nPress \'E\' To Exit The Game";

        LabelStyle style = new	LabelStyle(font, Color.PINK);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(400, 250);



        //	repeating	color	pulse	effect for instructions
        instructions.addAction(Actions.forever(Actions.sequence(Actions.color(	new	Color(216,27,96,1),	0.5f),
                Actions.delay(0.5f),
                Actions.color(new Color(0.5f, 0.5f, 0, 1),	0.5f))));

        uiStage.addActor(instructions);
        /*
        Table t	=	new	Table();
        t.setFillParent(true);
        uiStage.addActor(t);
        t.pad(20);

        //adding the title to the UI
        BaseActor title = new BaseActor();
        title.setTexture(new Texture(Gdx.files.internal("BeatzLogo.png")));
        t.add(title).colspan(2);
        t.center();

        //move to next row
        t.row();

        //adding the Electrosurge button to the UI
        Texture	electroSurgeTexture	=	new	Texture(Gdx.files.internal("Electrosurge.png"));
        Button.ButtonStyle electroSurgeStyle	=	new Button.ButtonStyle();
        electroSurgeStyle.up	=	new TextureRegionDrawable(new TextureRegion(electroSurgeTexture));
        Button	electroSurgeButton	=	new	Button(	electroSurgeStyle);

        electroSurgeButton.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {		return	true;		}
            public	void	touchUp	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {
                game.setScreen(	new ElectroSurgeScreen(game));
            }
        });

        t.add(electroSurgeButton).padTop(10).padBottom(10);
        t.center();

        //move to next row
        t.row();

        //adding the Jackson5 button to the UI
        Texture	Jackson5Texture	=	new	Texture(Gdx.files.internal("Jackson5.png"));
        Button.ButtonStyle Jackson5Style	=	new Button.ButtonStyle();
        Jackson5Style.up	=	new TextureRegionDrawable(new TextureRegion(Jackson5Texture));
        Button	jackson5Button	=	new	Button(	Jackson5Style);

        jackson5Button.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {		return	true;		}
            public	void	touchUp	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {
                game.setScreen(	new Jackson5Screen(game));
            }
        });
        t.add(jackson5Button).expandX();
        t.center();

        //move to next row
        t.row();

        //adding the Exit button to the UI
        Texture	exitTexture	=	new	Texture(Gdx.files.internal("Exit.png"));
        Button.ButtonStyle exitStyle	=	new Button.ButtonStyle();
        exitStyle.up	=	new TextureRegionDrawable(new TextureRegion(exitTexture));
        Button	exitButton	=	new	Button(	exitStyle);
        exitButton.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {		return	true;		}
            public	void	touchUp	(InputEvent	event,	float	x,	float	y,	int	pointer,	int	button)
            {
                Gdx.app.exit();
                System.exit(0);
            }
        });

        t.add(exitButton).expandX();
        t.center();*/
    }

    public void update(float dt) { }

    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.S:
                game.setScreen(new ElectroSurgeScreen(game));
                return true;
            case Input.Keys.W:
                game.setScreen(new Jackson5Screen(game));
                return true;
            case Input.Keys.E:
                Gdx.app.exit();
                System.exit(0);
        }
        return	false;
    }
}