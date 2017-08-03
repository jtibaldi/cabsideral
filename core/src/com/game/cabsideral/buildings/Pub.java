package com.game.cabsideral.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.cabsideral.*;
import com.game.cabsideral.codebase.AnimatedSprite;

public class Pub {
	//private static final int CHARACTER_WIDTH = 40; 
	//private static final int CHARACTER_HEIGHT = 40;
	private int pubBase_frame_cols = 4;
	private int pubBase_frame_rows = 3;
	//private int pubDoor_frame_cols = 4;
	//private int pubDoor_frame_rows = 3;
	private int gravityRing_frame_cols = 4;
	private int gravityRing_frame_rows = 3;
		
	private AnimatedSprite pubBaseSprite;
	//private AnimatedSprite pubDoorSprite;
	private AnimatedSprite gravityRingSprite;
	private float timer;
	private int pubBase_currentFrame;
	private int gravityRing_currentFrame;
		
	public Pub() {
		pubBaseSprite = new AnimatedSprite(mGame.assets.get("buildings/pub/build.png",Texture.class),pubBase_frame_cols,pubBase_frame_rows);
		gravityRingSprite = new AnimatedSprite(mGame.assets.get("buildings/pub/gravityring.png",Texture.class),gravityRing_frame_cols,gravityRing_frame_rows);
		pubBase_currentFrame = 0;
		gravityRing_currentFrame = 0;
	}
	
	public void update(float deltaTime) {
		timer += deltaTime;
		if(timer > .2) {
			pubBase_currentFrame++;
			timer = 0;
			if(pubBase_currentFrame > 10) {
				pubBase_currentFrame = 0;
			}
		}
		
		if(timer > .05)	{
			gravityRing_currentFrame++;
			timer = 0;
			if(gravityRing_currentFrame > 10) {
				gravityRing_currentFrame = 0;
			}
		}
	}
	
	public void draw(SpriteBatch batch) {
		pubBaseSprite.setFrame(pubBaseSprite.getAnimationFrames()[pubBase_currentFrame]);
		gravityRingSprite.setFrame(gravityRingSprite.getAnimationFrames()[gravityRing_currentFrame]);
		batch.draw(pubBaseSprite.getFrame(),200, 100);
		batch.draw(gravityRingSprite.getFrame(),150, 130);
	}
	
	//Getters and Setters
	public int getPubBaseCurrentFrame() {
		return pubBase_currentFrame;
	}
	
	public int getGravityRingCurrentFrame(){
		return gravityRing_currentFrame;
	}

	public void setPubBaseCurrentFrame(int currentFrame) {
		this.pubBase_currentFrame = currentFrame;
	}
	public void setGravityRingCurrentFrame(int currentFrame) {
		this.gravityRing_currentFrame = currentFrame;
	}	
}