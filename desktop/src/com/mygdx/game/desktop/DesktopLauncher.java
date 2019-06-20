package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.BeatzGame;
import com.mygdx.game.tester.ScorestreaksTester;
import com.mygdx.game.tester.SongPosTester;
import com.mygdx.game.tester.SpriteTest;

public class DesktopLauncher
{
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new BeatzGame(), config);
	}
}





