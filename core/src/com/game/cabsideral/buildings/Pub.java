package com.game.cabsideral.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.game.cabsideral.*;
import com.game.cabsideral.codebase.AnimatedSprite;
import com.game.cabsideral.codebase.B2DVars;
import com.game.cabsideral.screens.GameScreen;

public class Pub {
	//private static final int CHARACTER_WIDTH = 40; 
	//private static final int CHARACTER_HEIGHT = 40;
	private int pubBase_frame_cols = 4;
	private int pubBase_frame_rows = 3;
	//private int pubDoor_frame_cols = 4;
	//private int pubDoor_frame_rows = 3;
	private float pubBasePositionX;
	private float pubBasePositionY;		
	private AnimatedSprite pubBaseSprite;
	//private AnimatedSprite pubDoorSprite;
	private Sprite outerGravityRingSprite;
	private Sprite innerGravityRingSprite;
	private float gravityRingScale = 1f;
	private float pubBaseTimer;
	private int pubBase_currentFrame;
	private Body outerGravityRingBody;	
	
	public Pub(float _positionX,float _positionY, World world) {
		pubBaseSprite = new AnimatedSprite(mGame.assets.get("buildings/pub/build.png",Texture.class),pubBase_frame_cols,pubBase_frame_rows);
		pubBase_currentFrame = 0;
		pubBasePositionX = _positionX;
		pubBasePositionY = _positionY;		
		outerGravityRingSprite = new Sprite(mGame.assets.get("buildings/pub/outergravityring.png",Texture.class));
		innerGravityRingSprite = new Sprite(mGame.assets.get("buildings/pub/innergravityring.png",Texture.class));
		outerGravityRingSprite.setPosition(_positionX - 200 ,_positionY - 280);
		innerGravityRingSprite.setPosition(_positionX - 200 ,_positionY - 280);		
		BodyDef outerGravityRingBodyDef = new BodyDef();
        outerGravityRingBodyDef.type = BodyDef.BodyType.KinematicBody;
        outerGravityRingBodyDef.position.set((outerGravityRingSprite.getX() + outerGravityRingSprite.getWidth() / 2),
        					 (outerGravityRingSprite.getY() + outerGravityRingSprite.getHeight() / 2));
        outerGravityRingBody = world.createBody(outerGravityRingBodyDef);
        CircleShape shape = new CircleShape();
        System.out.println(outerGravityRingSprite.getWidth()/2); 
        shape.setRadius((outerGravityRingSprite.getWidth()/2 - 50));
        FixtureDef outerGravityRingfixtureDef = new FixtureDef();
        outerGravityRingfixtureDef.shape = shape;
        outerGravityRingfixtureDef.density = 0.1f;
        outerGravityRingfixtureDef.isSensor = true;
        outerGravityRingfixtureDef.filter.categoryBits = B2DVars.BIT_BUILDING_PLATFORM; //This
        outerGravityRingfixtureDef.filter.maskBits = B2DVars.BIT_CHARACTER | B2DVars.BIT_CLIENT;        
        outerGravityRingBody.createFixture(outerGravityRingfixtureDef).setUserData("outerGravityRing");
        shape.dispose();		
	}
	//427*317
	public void update(float deltaTime) {
		pubBaseTimer += deltaTime;
		if(pubBaseTimer > .2) {
			pubBase_currentFrame++;
			pubBaseTimer = 0;
			if(pubBase_currentFrame > 10) {
				pubBase_currentFrame = 0;
			}
		}				
		innerGravityRingSprite.setScale(gravityRingScale);
		gravityRingScale -= .01f;					
		if(gravityRingScale <= 0) { gravityRingScale = 1f; }		
	}
	
	public void draw(SpriteBatch batch) {
		pubBaseSprite.setFrame(pubBaseSprite.getAnimationFrames()[pubBase_currentFrame]);
		outerGravityRingSprite.draw(batch);
		innerGravityRingSprite.draw(batch);		
		batch.draw(pubBaseSprite.getFrame(),pubBasePositionX, pubBasePositionY);		
	}
	
	//Getters and Setters
	public int getPubBaseCurrentFrame() {
		return pubBase_currentFrame;
	}	
	public void setPubBaseCurrentFrame(int currentFrame) {
		this.pubBase_currentFrame = currentFrame;
	}		
}