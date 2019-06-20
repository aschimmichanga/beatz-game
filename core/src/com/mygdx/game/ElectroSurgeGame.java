package com.mygdx.game;

import	com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Action;
import	com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import	com.badlogic.gdx.scenes.scene2d.ui.Label;
import	com.badlogic.gdx.scenes.scene2d.InputListener;
import	com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.utils.BaseActor;
import com.mygdx.game.utils.BaseScreen;

import java.util.ArrayList;

//ASHNA

public	class ElectroSurgeGame extends BaseScreen {
    private	float	spawnTimer;
    private	final float	spawnInterval = .001f;
    private	int	missed;
    private	int	score;
    private	Label	songLabel;
    private	Label	scoreLabel;
    private Song song;

    private ArrayList<Note> noteList;

    //	game	world
    private final int mapWidth	= 1280;
    private final int mapHeight = 600;

    public ElectroSurgeGame(com.mygdx.game.utils.BaseGame g)
    {
        super(g);

        //initializations
        noteList = new ArrayList<Note>();

        //set background of the game
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/tokyo.gif")));
        uiStage.addActor(background);


        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);


        songLabel = new Label("Current Song: Surge - Noisestorm", style);
        songLabel.setPosition(0,0);
        scoreLabel = new Label("Score: ", style);

    }
    public	void create()
    {
        FileHandle file = Gdx.files.internal("Song1.txt");
        String text = file.readString();

        //parsing through the CSV
        while (text.contains(","))
        {
            int secondCommaIndex = text.substring(text.indexOf(",") + 1).indexOf(",");
            noteList.add(new Note(text.substring(0, secondCommaIndex)));
            text = text.substring(secondCommaIndex + 1);
        }

        song = new Song("ElectroSurge.mp3", 0, 128);
        song.getMusic().play();

        BaseActor hit1 = new BaseActor();
        hit1.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
        hit1.setPosition(Note.X1,0);
        uiStage.addActor(hit1);

        BaseActor hit2 = new BaseActor();
        hit2.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
        hit2.setPosition(Note.X2,0);
        uiStage.addActor(hit2);

        BaseActor hit3 = new BaseActor();
        hit3.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
        hit3.setPosition(Note.X3,0);
        uiStage.addActor(hit3);

        BaseActor hit4 = new BaseActor();
        hit4.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
        hit4.setPosition(Note.X4,0);
        uiStage.addActor(hit4);
    }
    public void update(float dt)
    {
        //using note.getTime() to know when to spawn
        int frameRate = (int)((1.0/dt)+0.5);
        int speed = (int)((Note.startingHeight/frameRate)+ 0.5);

        spawnTimer	+=	dt;				//	check time for next
        if	(spawnTimer	> spawnInterval)
        {
            spawnTimer -= spawnInterval;
            final Note n = noteList.get(0);

            n.setVelocityAS(-90, speed);

            //checking which note it is (1,2,3,4) and assigning the appropriate image
            switch (n.getNote())
            {
                case 1:
                    n.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
                    n.setPosition(Note.X1, Note.startingHeight);
                    break;
                case 2:
                    n.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
                    n.setPosition(Note.X2, Note.startingHeight);
                    break;
                case 3:
                    n.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
                    n.setPosition(Note.X3, Note.startingHeight);
                    break;
                case 4:
                    n.setTexture(new Texture(Gdx.files.internal("Speaker.gif")));
                    n.setPosition(Note.X4, Note.startingHeight);
                    break;
            }

            uiStage.addActor(n);

            //moving the note down the screen
            Action moveDown = Actions.moveBy(0,speed);
            n.addAction(moveDown);

            while (n.getX() < mapHeight)
            {
                n.velocityX += 100;
            }

            n.addListener(new InputListener()
            {
                public boolean keyTyped(InputEvent event, char character)
                {
                    if (character == (char)(n.getNote() + '0')) //does the number typed match the note number
                    {
                        float inaccuracy = (float) Math.abs(song.getSongPosition() - n.getTime());
                        
                        /*
                            Scoring:
                            Perfect (500 pts): within 100 milliseconds of the song position
                            Good (250 pts): within 250 milliseconds of the song position
                            Miss: anything that is at least 250 milliseconds of the song position (notes will be voided as soon as they hit the bottom of the screen)
                        */

                        if (inaccuracy < .100)
                            score += 500;
                        else if (inaccuracy < .250)
                            score += 250;
                        n.remove();
                        noteList.remove(0);
                        return true;
                    }
                    return false; //check this
                }
            });
        }

        //	remove	balloons	that	are	off-screen
        for	(Actor a : uiStage.getActors())
        {
            if (a.getX() > mapWidth ||	a.getY() > mapHeight) //are sprites still on the screen
            { 
                missed++;
                a.remove();
            }
        }

        //	update	user	interface
        scoreLabel.setText("Score:	"	+	score);
    }
}