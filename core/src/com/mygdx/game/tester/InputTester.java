package com.mygdx.game.tester;

import com.badlogic.gdx.Gdx;

public class InputTester
{
    public static boolean onePressed;
    public static boolean twoPressed;
    public static boolean threePressed;
    public static boolean fourPressed;
    public static boolean oneReleased;
    public static boolean twoReleased;
    public static boolean threeReleased;
    public static boolean fourReleased;

    //every time a beat passes, these must be reset to false

    public static void main(String[] args)
    {
        onePressed = false;
        twoPressed = false;
        threePressed = false;
        fourPressed = false;
        oneReleased = false;
        twoReleased = false;
        threeReleased = false;
        fourReleased = false;

        //if pressed
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.NUM_1))
        {
            onePressed = true;
            oneReleased = false;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.NUM_2))
        {
            twoPressed = true;
            twoReleased = false;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.NUM_3))
        {
            threePressed = true;
            threeReleased = false;
        }
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.NUM_4))
        {
            fourPressed = true;
            fourReleased = false;
        }

        //if released
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_1))
        {
            oneReleased = true;
            onePressed = false;
        }
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_2))
        {
            twoReleased = true;
            twoPressed = false;
        }
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_3))
        {
            threeReleased = true;
            threePressed = false;
        }
        if (Gdx.input.isKeyJustPressed(com.badlogic.gdx.Input.Keys.NUM_4))
        {
            fourReleased = true;
            fourPressed = false;
        }
    }
}

