package com.mygdx.game;

import	com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.utils.BaseActor;

//ASHNA

public class Menu extends com.mygdx.game.utils.BaseScreen
{
    protected Table t;

    public Menu (com.mygdx.game.utils.BaseGame g)
    {
        super(g);
    }

    public void create()
    {
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/findbackground.jpg")));
        uiStage.addActor(background);

        t	=	new	Table();
        t.setFillParent(true);
        uiStage.addActor(t);
        t.pad(20);

        //adding the title to the UI
        BaseActor a = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/BeatzLogo.jpg")));
        t.add(a).expandX();

        //move to next row
        t.row();

        //adding the Electrosurge button to the UI
        Texture	electroSurgeTexture	=	new	Texture(Gdx.files.internal("assets/Guitar.png"));
        Button.ButtonStyle electroSurgeStyle	=	new Button.ButtonStyle();
        electroSurgeStyle.up	=	new TextureRegionDrawable(new TextureRegion(electroSurgeTexture));
        Button	electroSurgeButton	=	new	Button(	electroSurgeStyle);

        electroSurgeButton.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent event, float	x, float	y, int	pointer, int	button)
            {
                game.setScreen(	new	Menu(game));
                return	true;
            }
        });
        t.add(electroSurgeButton).expandX();

        //move to next row
        t.row();

        //adding the Jackson5 button to the UI
        Texture	Jackson5Texture	=	new	Texture(Gdx.files.internal("assets/Guitar.png"));
        Button.ButtonStyle Jackson5Style	=	new Button.ButtonStyle();
        Jackson5Style.up	=	new TextureRegionDrawable(new TextureRegion(Jackson5Texture));
        Button	Jackson5Button	=	new	Button(	Jackson5Style);

        Jackson5Button.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent event, float	x, float	y, int	pointer, int	button)
            {
                game.setScreen(	new	Menu(game));
                return	true;
            }
        });
        t.add(Jackson5Button).expandX();

        //move to next row
        t.row();

        //adding the Exit button to the UI
        Texture	exitTexture	=	new	Texture(Gdx.files.internal("assets/Exit.png"));
        Button.ButtonStyle exitStyle	=	new Button.ButtonStyle();
        exitStyle.up	=	new TextureRegionDrawable(new TextureRegion(exitTexture));
        Button	exitButton	=	new	Button(	exitStyle);

        exitButton.addListener(new	InputListener()
        {
            public	boolean	touchDown	(InputEvent event, float	x, float	y, int	pointer, int	button)
            {
                Gdx.app.exit();
                System.exit(0);
                return	true;
            }
        });

        t.add(exitButton).expandX();



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
}