package com.mygdx.game.utils;

import com.badlogic.gdx.math.MathUtils;
import	com.badlogic.gdx.math.Vector2;
import com.mygdx.game.utils.AnimatedActor;

//ASHNA

public	class	PhysicsActor	extends AnimatedActor
{
    private	Vector2	velocity;
    private	Vector2	acceleration;				//	maximum	speed
    private	float	maxSpeed;				//	speed	reduction,	in	pixels/second,	when	not	accelerating
    private	float	deceleration;				//	should	image	rotate	to	match	velocity?
    private	boolean	autoAngle;
     public	PhysicsActor()
     {
         velocity	=	new	Vector2();
         acceleration	=	new	Vector2();
         maxSpeed	=	9999;
         deceleration	=	0;
         autoAngle	=	false;
     }

    //	velocity	methods
    public	void	setVelocityXY(float	vx,	float	vy)
    {
        velocity.set(vx,vy);
    }
    public	void	addVelocityXY(float	vx,	float	vy)
    {
        velocity.add(vx,vy);
    }

    //	set	velocity	from	angle	and	speed
    	public	void	setVelocityAS(float	angleDeg,	float	speed)
    	{
    	velocity.x	=	speed	*	MathUtils.cosDeg(angleDeg);
    	velocity.y	=	speed	*	MathUtils.sinDeg(angleDeg);
    	}
    	//	acceleration/deceleration	methods
        	public	void	setAccelerationXY(float	ax,	float	ay)
        	{
        	acceleration.set(ax,ay);
        	}
        	public	void	addAccelerationXY(float	ax,	float	ay)
        	{		acceleration.add(ax,ay);		}
        	//	set	acceleration	from	angle	and	speed
            	public	void	setAccelerationAS(float	angleDeg,	float	speed)
                {
                    acceleration.x	=	speed	*	MathUtils.cosDeg(angleDeg);
                    acceleration.y	=	speed	*	MathUtils.sinDeg(angleDeg);
                }
                public	void	setDeceleration(float	d)				{		deceleration	=	d;		}

                //Related	utility	methods	determine	the	speed	and	angle	of	motion	of	the actor,	change	the	current	speed,	and	accelerate	in	the	direction	the	actor	is	currently facing:
                 public	float	getSpeed()				        {		return	velocity.len();		}
                 public	void	setSpeed(float	s)				{		velocity.setLength(s);		}
                 public	void	setMaxSpeed(float	ms)			{		maxSpeed	=	ms;		    }
                 public	float	getMotionAngle()				{		return	MathUtils.atan2(velocity.y,	velocity.x) *	MathUtils.radiansToDegrees;	}
                 public	void	setAutoAngle(boolean	b)		{		autoAngle	=	b;		    }
                 public	void	accelerateForward(float	speed)  {		setAccelerationAS(getRotation(), speed);	}
}