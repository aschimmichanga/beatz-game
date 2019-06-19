package com.mygdx.game;

import	com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import	com.badlogic.gdx.scenes.scene2d.Actor;
import	com.badlogic.gdx.scenes.scene2d.ui.Label;
import	com.badlogic.gdx.scenes.scene2d.InputListener;
import	com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.mygdx.game.utils.BaseActor;
import com.mygdx.game.utils.BaseScreen;

import java.util.ArrayList;

public	class ElectroSurgeGame extends BaseScreen {
    private BaseActor background;
    private	float	spawnTimer;
    private	final float	spawnInterval = .001f;
    private	int	popped;
    private	int	missed;
    private	int	score;
    private	Label	songLabel;
    private	Label	scoreLabel;
    private	Label	streaksLabel;
    private Song song;

    private ArrayList<Note> noteList;

    //	game	world
    final	int	mapWidth	=	1280;
    final	int	mapHeight	=	600;

    public ElectroSurgeGame(com.mygdx.game.utils.BaseGame g)
    {
        super(g);

        //set background of the game
        background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("assets/tokyo.gif")));
        uiStage.addActor(background);

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
    }
    public	void	update(float	dt)
    {
        //using note.getTime() to know when to spawn

        spawnTimer	+=	dt;				//	check time for next
        if	(spawnTimer	> spawnInterval)
        {
            spawnTimer	-=	spawnInterval;
            final Note	n	=	noteList.get(0);
            n.addListener(	new	InputListener()
            {
                public boolean keyTyped(InputEvent event, char character)
                {
                    if (character == (char)(n.getFirstNote() + '0')) {
                        float inaccuracy = (float) Math.abs(song.getSongPosition() - n.getTime());
                        /*
                            Scoring:
                            Perfect (500 pts): within 100 milliseconds of the song position
                            Good (250 pts): within 250 milliseconds of the song position
                            Miss: anything that is at least 250 milliseconds of the song position (notes will be voided as soon as they hit the bottom of the screen)
                        */

                        if (inaccuracy < .1)
                            score += 500;
                        else if (inaccuracy < .25)
                            score += 250;
                        n.remove();
                        noteList.remove(0);
                        return true;


                    }
                    else if (n.getSecondNote() == 0)
                    {
                        //TODO: Handle two note detection
                    }
                    return false; //check this
                }
            });
            mainStage.addActor(n);
        }				//	remove	balloons	that	are	off-screen
        for	(Actor a : mainStage.getActors())
        {
            if	(a.getX()	>	mapWidth	||	a.getY()	>	mapHeight)
            {
                missed++;
                a.remove();
            }
        }

        //	update	user	interface
        //TODO: insert song details for each song as a header during the game
        songLabel.setText("Song:	"	+	"ElectroSurge");
        scoreLabel.setText("Score:	"	+	score);
        streaksLabel.setText("Current Streak:	" ); //scorestreaks implementation
    }
}