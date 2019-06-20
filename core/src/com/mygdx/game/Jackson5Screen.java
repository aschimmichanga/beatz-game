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

public class Jackson5Screen extends BaseScreen {
    private	float	spawnTimer;
    private	final float	spawnInterval = .470f;
    private	int	missed;
    private	int	score;
    private	Label	songLabel;
    private	Label	scoreLabel;
    private Song song;

    private ArrayList<Note> noteList;

    //	game	world
    private final int mapWidth	= 1280;
    private final int mapHeight = 600;

    public Jackson5Screen(Game g)
    {
        super(g);

        //initializations
        noteList = new ArrayList<Note>();

        //set background of the game
        BaseActor background = new BaseActor();
        background.setTexture(new Texture(Gdx.files.internal("Soundwave.jpg")));
        uiStage.addActor(background);


        //draw the hitboxes
        BaseActor pink	= new BaseActor();
        pink.setTexture( new Texture(Gdx.files.internal("PinkHitButton.png")));
        pink.setPosition(256,0);
        uiStage.addActor(pink);

        BaseActor teal	= new BaseActor();
        teal.setTexture( new Texture(Gdx.files.internal("TealHitButton.png")));
        teal.setPosition(416,0);
        uiStage.addActor(teal);

        BaseActor purple	= new BaseActor();
        purple.setTexture( new Texture(Gdx.files.internal("PurpleHitButton.png")));
        purple.setPosition(576,0);
        uiStage.addActor(purple);

        BaseActor blue	= new BaseActor();
        blue.setTexture( new Texture(Gdx.files.internal("BlueHitButton.png")));
        blue.setPosition(736,0);
        uiStage.addActor(blue);


        //add labels

        BitmapFont font = new BitmapFont();
        Label.LabelStyle style = new Label.LabelStyle(font, Color.WHITE);

        songLabel = new Label("Current Song: Surge - Noisestorm", style);
        songLabel.setPosition(16, 540);
        uiStage.addActor(songLabel);

        scoreLabel = new Label("Score: ", style);
        scoreLabel.setPosition(16, 510);
        uiStage.addActor(scoreLabel);

        noteList = new ArrayList<Note>();

        FileHandle file = Gdx.files.internal("Song1.txt");
        String text = file.readString();

        //parsing through the CSV
        while (text != null && text.length() > 3)
        {
            noteList.add(new Note(text.substring(0, 3), 0.470f));
            text = text.substring(4);
        }

        if (text != null && text.length() == 3)
            noteList.add(new Note(text, 0.470f));
    }
    public	void create()
    {
        song = new Song("ElectroSurge.mp3", 0, 128, 0.470f);
        song.getMusic().play();


    }
    public void update(float dt)
    {

    }
    public void render (float dt)
    {
        //using note.getTime() to know when to spawn

        int frameRate = (int)((1.0/dt) + 0.5);
        int speed = (int)((Note.startingHeight/frameRate)+ 0.5) * -1;

        spawnTimer	+=	dt;				//	check time for next
        if(spawnTimer > spawnInterval){
            spawnTimer -= spawnInterval;
            final Note n = noteList.get(0);

            //checking which note it is (1,2,3,4) and assigning the appropriate image
            switch (n.getNote()){
                case 1:
                    n.setTexture(new Texture(Gdx.files.internal("PinkGuitar.png")));
                    n.setPosition(Note.X1, Note.startingHeight); //spawn off of the screen
                    break;
                case 2:
                    n.setTexture(new Texture(Gdx.files.internal("TealGuitar.png")));
                    n.setPosition(Note.X2, Note.startingHeight);
                    break;
                case 3:
                    n.setTexture(new Texture(Gdx.files.internal("PurpleGuitar.png")));
                    n.setPosition(Note.X3, Note.startingHeight);
                    break;
                case 4:
                    n.setTexture(new Texture(Gdx.files.internal("BlueGuitar.png")));
                    n.setPosition(Note.X4, Note.startingHeight);
                    break;
            }

            uiStage.addActor(n);

            //moving the note down the screen
            Action moveDown = Actions.moveBy(0,speed);
            n.addAction(moveDown);
            n.act(dt);
            uiStage.act(dt);

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
                    return false;
                }
            });
        }

        //	remove	sprites	that are	off-screen
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
        uiStage.draw();
    }
}