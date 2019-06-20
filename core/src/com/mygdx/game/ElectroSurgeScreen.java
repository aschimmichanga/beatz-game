package com.mygdx.game;

import com.badlogic.gdx.Game;
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

public	class ElectroSurgeScreen extends BaseScreen {
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

    public ElectroSurgeScreen(Game g)
    {
        super(g);

        //initializations
        noteList = new ArrayList<Note>();

        //set background of the game
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("tokyo.gif")));
        uiStage.addActor(background);


        //add labels

        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);

        songLabel = new Label("Current Song: Surge - Noisestorm", style);
        songLabel.setPosition(16, 540);
        uiStage.addActor(songLabel);

        scoreLabel = new Label("Score: ", style);
        scoreLabel.setPosition(16, 510);
        uiStage.addActor(scoreLabel);

    }
    public	void create()
    {
        song = new Song("ElectroSurge.mp3", 0, 128, 0.470f);

        FileHandle file = Gdx.files.internal("Song1.txt");
        String text = file.readString();

        //parsing through the CSV
        while (text.charAt(0) != '!')
        {
            noteList.add(new Note(text.substring(0, 3), 0.470f));
            text = text.substring(4);
        }


        song.getMusic().play();


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

            n.setSpeed(speed);

            uiStage.addActor(n);

            //moving the note down the screen
            Action moveDown = Actions.moveBy(0,speed);
            n.addAction(moveDown);

            n.addListener(new InputListener()
            {
                public boolean keyTyped(InputEvent event, char character)
                {
                    if (character == (char)(n.getNote() + '0')) //does the number typed match the note number
                    {
                        float inaccuracy = (float) Math.abs(song.getSongPosition() - n.getSongPos());
                        
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