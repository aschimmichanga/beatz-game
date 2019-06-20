package com.mygdx.game.utils;

//ASHNA

import	com.badlogic.gdx.graphics.g2d.Batch;
import	com.badlogic.gdx.graphics.Texture;
import	com.badlogic.gdx.graphics.g2d.Animation;
import	com.badlogic.gdx.math.MathUtils;

public	class AnimatedActor	extends BaseActor {

    public float elapsedTime;
    public Animation<Texture> anim;

    public AnimatedActor()
    {
        super();
        elapsedTime	= 0;
    }
    public void	setAnimation(Animation<Texture> a)
    {
        Texture	t =	a.getKeyFrame(0);
        setTexture(t);
        anim =	a;
    }

    public	void act(float	dt)
    {
        super.act(dt);
        elapsedTime	+= dt;
        if	(velocityX != 0	|| velocityY !=	0)
            setRotation(MathUtils.atan2(velocityY, velocityX) *	 MathUtils.radiansToDegrees);
    }

    public void draw(Batch batch, float	parentAlpha)
    {
        //region.setRegion(anim.getKeyFrame(elapsedTime));
        super.draw(batch, parentAlpha);
    }
}