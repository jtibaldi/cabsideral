package com.game.cabsideral.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.game.cabsideral.mGame;
/*
 * Begin -Code for debug Box2D shape collisions
 */
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
/*
 * End -Code for debug Box2D shape collisions
 */
import com.game.cabsideral.buildings.Pub;
import com.game.cabsideral.codebase.Character;
import com.game.cabsideral.engine.ContactEngine;

public class GameScreen extends Screen {
	public static final float PIXELS_TO_METERS = 100f;
	
	private World world;
	private Character character;
	private Sprite testBackground;	
	private Pub testBuildingSP;
	private Pub testBuildingSP2;
	private Pub testBuildingSP3;
	/*
	 * 	Begin - Code for debug Box2D shape collisions 
	 */
	private Box2DDebugRenderer debugRenderer;
    private Matrix4 debugMatrix;
   /*
	 * 	End - Code for debug Box2D shape collisions 
	 */		
	public GameScreen() 
	{
		/*
		 * 	Begin - Code for debug Box2D shape collisions 
		 */
		debugRenderer = new Box2DDebugRenderer();
		/*
		 * 	End - Code for debug Box2D shape collisions
		 */	
		world = new World(new Vector2(0,0), true);		
		world.setContactListener(new ContactEngine(this));
		character = new Character(world);
		testBackground = new Sprite(mGame.assets.get("resSop.png",Texture.class));  
	    testBackground.setPosition(-960, -768);  
	    testBackground.setSize(1920, 1536);
	    testBuildingSP = new Pub(380,80, world);	        
	    testBuildingSP2 = new Pub(-800,0, world);
	    testBuildingSP3 = new Pub(-180,-300, world); //-320
	}
	
	public void update(float deltaTime) 
	{
		testBuildingSP.update(deltaTime);
		testBuildingSP2.update(deltaTime);
		testBuildingSP3.update(deltaTime);			
		character.update(deltaTime);
		world.step(deltaTime, 6, 2);		
	}
	
	public void draw(SpriteBatch batch) 
	{
		debugMatrix = batch.getProjectionMatrix().cpy();
		debugRenderer.render(world, debugMatrix);                
		testBackground.draw(batch);
		testBuildingSP.draw(batch);
		testBuildingSP2.draw(batch);	
		testBuildingSP3.draw(batch);
		character.draw(batch);		
	}
	
	public void dispose() 
	{
		world.dispose();		
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Pub getTestBuildingSP() {
		return testBuildingSP;
	}

	public void setTestBuildingSP(Pub testBuildingSP) {
		this.testBuildingSP = testBuildingSP;
	}

	public Pub getTestBuildingSP2() {
		return testBuildingSP2;
	}

	public void setTestBuildingSP2(Pub testBuildingSP2) {
		this.testBuildingSP2 = testBuildingSP2;
	}

	public Pub getTestBuildingSP3() {
		return testBuildingSP3;
	}

	public void setTestBuildingSP3(Pub testBuildingSP3) {
		this.testBuildingSP3 = testBuildingSP3;
	}	
}