package com.game.cabsideral.codebase;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.game.cabsideral.mGame;
import com.game.cabsideral.screens.GameScreen;

public class Character {
	//private int character_width = 50; 
	//private int character_height = 80;
	private Sprite characterSprite;
	private Body characterBody;	
	
	public Character(World world) 
	{		
		characterSprite = new Sprite(mGame.assets.get("character/character.png",Texture.class));		
		BodyDef characterBodyDef = new BodyDef();
        characterBodyDef.type = BodyDef.BodyType.DynamicBody;
        characterBodyDef.position.set((characterSprite.getX() + characterSprite.getWidth() / 2),
        					 (characterSprite.getY() + characterSprite.getHeight() / 2));
        characterBody = world.createBody(characterBodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(characterSprite.getWidth()/2, characterSprite.getHeight()/2);
        FixtureDef characterFixtureDef = new FixtureDef();
        characterFixtureDef.shape = shape;
        characterFixtureDef.density = 0.1f;
        characterFixtureDef.filter.categoryBits = B2DVars.BIT_CHARACTER; //This
        characterFixtureDef.filter.maskBits = B2DVars.BIT_CLIENT | B2DVars.BIT_OUTERRING | B2DVars.BIT_BUILDING_PLATFORM;    
        characterBody.createFixture(characterFixtureDef).setUserData("character");
        shape.dispose();        
	}
	
	public void update(float deltaTime) 
	{	
		
		characterSprite.setPosition(characterBody.getPosition().x, characterBody.getPosition().y);		
	} 
	
	public void draw(SpriteBatch batch) 
	{
		characterSprite.draw(batch);		
	}

	public Sprite getCharacterSprite() {
		return characterSprite;
	}

	public void setCharacterSprite(Sprite characterSprite) {
		this.characterSprite = characterSprite;
	}

	public Body getBody() {
		return characterBody;
	}

	public void setBody(Body body) {
		this.characterBody = body;
	}
}