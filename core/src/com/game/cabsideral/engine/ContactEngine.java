package com.game.cabsideral.engine;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.game.cabsideral.buildings.Pub;
import com.game.cabsideral.codebase.UserDataWrapper;
import com.game.cabsideral.codebase.Character;
import com.game.cabsideral.screens.GameScreen;

public class ContactEngine implements ContactListener {

	GameScreen mWorld;	
	
	public ContactEngine(GameScreen _world) 
	{
		mWorld = _world;
	}
	
	@Override
	public void beginContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();	
		
		UserDataWrapper oFa = (UserDataWrapper)(fa.getUserData());
		UserDataWrapper oFb = (UserDataWrapper)(fb.getUserData());
				
		if(oFa != null && oFa.id =="character") 
		{
			if(oFb != null && oFb.id == "outerGravityRing") 
			{
				//Poner todas las estructuras como instanceof
				System.out.println("habilita la gravedad y character es a");
				if(oFb.instance instanceof Pub) 
				{
					//((Character)oFa.instance).setPlanetMass(/*((Pub)oFb.instance).getCenterOfMassBody().getMass()*/ 3000);
					Vector2 position = ((Pub)oFb.instance).getCenterOfMassBody().getPosition();
					((Character)oFa.instance).setPlanetPosition(new Vector2(position.x, position.y));
					//((Character)oFa.instance).setPlanetWorldCenter(((Pub)oFb.instance).getCenterOfMassBody().getWorldCenter());
					((Character)oFa.instance).setGravityEnable(true);		
				}				
			}					
		}		
		if(oFb != null && oFb.id == "character") 
		{
			if(oFa != null && oFa.id == "outerGravityRing") 
			{
				System.out.println("habilita la gravedad y character es b");
				if(oFb.instance instanceof Pub) 
				{
					//((Character)oFa.instance).setPlanetMass(/*((Pub)oFb.instance).getCenterOfMassBody().getMass()*/ 3000);
					((Character)oFa.instance).setPlanetPosition(((Pub)oFb.instance).getCenterOfMassBody().getPosition());
					//((Character)oFa.instance).setPlanetWorldCenter(((Pub)oFb.instance).getCenterOfMassBody().getWorldCenter());
					((Character)oFa.instance).setGravityEnable(true);		
				}			
			}	
		}		
	}

	@Override
	public void endContact(Contact contact) {
		
		Fixture fa = contact.getFixtureA();
		Fixture fb = contact.getFixtureB();	
		
		UserDataWrapper oFa = (UserDataWrapper)(fa.getUserData());
		UserDataWrapper oFb = (UserDataWrapper)(fb.getUserData());
				
		if(oFa != null && oFa.id =="character") 
		{
			if(oFb != null && oFb.id == "outerGravityRing") 
			{
				System.out.println("deshabilita la gravedad y character es a");				
				mWorld.getCharacter().setGravityEnable(false);
			}					
		}		
		if(oFb != null && oFb.id == "character") 
		{
			if(oFa != null && oFa.id == "outerGravityRing") 
			{
				System.out.println("deshabilita la gravedad y character es b");
				mWorld.getCharacter().setGravityEnable(false);			
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