package com.mygdx.game;
//ASHNA

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.compression.lzma.Base;
import com.mygdx.game.utils.BaseActor;
import com.mygdx.game.utils.PhysicsActor;

public class Note extends PhysicsActor {
  private int note;
  private double songPos; //what song position the note occurs at
  private float duration;

  //x positions of each note
  public static final int X1 = 256;
  public static final int X2 = 416;
  public static final int X3 = 576;
  public static final int X4 = 736;

  public	float	speed;
  public	float	amplitude;
  public	float	oscillation;
  public	float	initialY;
  public	float	time;

  //y position of spawns
  public static final int startingHeight = 466;
  public static final int offsetY = 134; //for spawning off of the screen

  public Note(String notesAndTime, float baseInterval)
  {
    //txt file formatting template for reference:
    //note,time,
    
    note = Character.getNumericValue(notesAndTime.charAt(0));
    char noteType = notesAndTime.charAt(2);
    duration = baseInterval;

    switch (noteType)
    {
      case 'w':
        duration *= 2;
      case 'h':
        duration *= 2;
      //case q is just the base interval, because the base interval = length of a quarter note
    }
  }

  public	void	act(float	dt)
  {
    super.act(dt);
    time +=	dt;
    //	set	starting	location	to	top	of	window
    float	yPos	=	initialY - (speed * time);
    setY(yPos);
  }

  //getters
  public double getSongPos() {
    return songPos;
  }

  public int getNote() {
    return note;
  }
}


