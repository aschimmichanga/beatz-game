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
    private	float	spawnInterval;
    private	int	popped;
    private	int	missed;
    private	int	score;
    private	Label	songLabel;
    private	Label	scoreLabel;
    private	Label	streaksLabel;

    private ArrayList<Note> noteList;

    //	game	world
    final	int	mapWidth	=	1280;
    final	int	mapHeight	=	600;

    public ElectroSurgeGame(com.mygdx.game.utils.BaseGame g)
    {
        super(g);

        //set background of the game
        background.setTexture(new Texture(Gdx.files.internal("assets/tokyo.gif")));
        uiStage.addActor(background);

        FileHandle file = Gdx.files.internal("Song1.txt");
        String text = file.readString();

        //parsing through the CSV
        while (text.contains(","))
        {
            int secondCommaIndex = text.substring(text.indexOf(",") + 1).indexOf(",");
            noteList.add(new Note(text.substring(0, secondCommaIndex)));
            text = text.substring(secondCommaIndex + 1);
        }
    }
    public	void	create()
    {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            while (true) {
                String noteList = reader.readLine();
                int charsRemaining = noteList.length();
                int startingPt = 0;
               while (charsRemaining > 0)
                {
                        String note = noteList.substring(startingPt, ",") + (",", ",");
                        Note n = new Note(note);
                        charsRemaining -= note.length();
                        startingPt += note.length();
                }
                if (line == null)
                {
                    break;
                }
            }
        }
    }
    public	void	update(float	dt)
    {

        //using note.getTime() to know when to spawn

        spawnTimer	+=	dt;				//	check	time	for	next	balloon	spawn
        if	(spawnTimer	>	spawnInterval)
        {
            spawnTimer	-=	spawnInterval;
            final Note	n	=	noteList.get(0);
            n.addListener(	new	InputListener()

            {
                public boolean keyTyped(InputEvent event, char character)
                {
                    if (character == (char)(n.getFirstNote() + '0'))
                    {
                        //score streaks implementation
                        n.remove();
                        noteList.remove(0);
                        return true;
                        //TODO: Handle two note detection
                    }
                    return false; //check this
                }
            });
            mainStage.addActor(n);
        }				//	remove	balloons	that	are	off-screen
        for	(Actor	a	:	mainStage.getActors())
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