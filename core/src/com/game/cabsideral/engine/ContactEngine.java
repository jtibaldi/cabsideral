package com.game.cabsideral.engine;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;

public class ContactEngine implements ContactListener {

	World mWorld;
	
	public ContactEngine(World _world) 
	{
		mWorld = _world;
	}
	
	@Override
	public void beginContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();	
		
		if(fa.getUserData() != null && fa.getUserData().equals("character")) 
		{
			if(fb.getUserData() != null && fb.getUserData().equals("outerGravityRing")) 
			{
				mWorld.setGravity(new Vector2(0,-98f));				
			}					
		}		
		if(fb.getUserData() != null && fb.getUserData().equals("character")) 
		{
			if(fa.getUserData() != null && fa.getUserData().equals("outerGravityRing")) 
			{
				mWorld.setGravity(new Vector2(0,-98f));					
			}					
		}
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();	
				
		
		
		if(fa.getUserData() != null && fa.getUserData().equals("character")) 
		{
			if(fb.getUserData() != null && fb.getUserData().equals("outerGravityRing")) 
			{
				mWorld.setGravity(Vector2.Zero);
			}					
		}		
		if(fb.getUserData() != null && fb.getUserData().equals("character")) 
		{
			if(fa.getUserData() != null && fa.getUserData().equals("outerGravityRing")) 
			{
				mWorld.setGravity(Vector2.Zero);			
			}					
		}
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

	
}
