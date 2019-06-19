package com.mygdx.game.utils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import	com.badlogic.gdx.scenes.scene2d.ui.Skin;
public	abstract	class	BaseGame	extends Game
{
    //	used	to	store	resources	common	to	multiple	screens
    	Skin	skin;
    	public	BaseGame()
        {
            skin	=	new	Skin(); 
            Color white	=	new	Color(0f,	0f,	0f,	0f);
            skin.add("White",	white);
            Color	textColor	=	skin.get("White",	Color.class	);
        }

        public	abstract	void	create();
    	public	void	dispose()
        {
            skin.dispose();
        }
}
