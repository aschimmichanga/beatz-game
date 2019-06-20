package com.mygdx.game;

import com.badlogic.gdx.Game;

public class BeatzGame extends Game
{
    public	void	create()
    {
        //	initialize	and	start	main	game
        StartScreen s	=	new StartScreen(this);
        setScreen(s);
    }
}
