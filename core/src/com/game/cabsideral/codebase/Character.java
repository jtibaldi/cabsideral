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
	private boolean gravityEnable = false;
	private float planetMass;
	private Vector2 planetPosition;
	private Vector2 planetWorldCenter;
	
	public Character(World world) 
	{		
		characterSprite = new Sprite(mGame.assets.get("character/character.png",Texture.class));
		characterSprite.setPosition(-5, 200);
		BodyDef characterBodyDef = new BodyDef();        
		characterBodyDef.type = BodyDef.BodyType.DynamicBody;
        characterBodyDef.position.set((characterSprite.getX() + characterSprite.getWidth() / 2),
        					 (characterSprite.getY() + characterSprite.getHeight() / 2));
        characterBody = world.createBody(characterBodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(characterSprite.getWidth()/2, characterSprite.getHeight()/2);
        
        FixtureDef characterFixtureDef = new FixtureDef();
        characterFixtureDef.shape = shape;
        characterFixtureDef.density = 1f;
        characterFixtureDef.filter.categoryBits = B2DVars.BIT_CHARACTER; //This
        characterFixtureDef.filter.maskBits = B2DVars.BIT_CLIENT | B2DVars.BIT_OUTERRING | B2DVars.BIT_BUILDING_PLATFORM;    
        characterBody.createFixture(characterFixtureDef).setUserData(new UserDataWrapper("character","Character",this));
        shape.dispose();        
	}
	
	public void update(float deltaTime) 
	{			
		characterSprite.setPosition(characterBody.getPosition().x, characterBody.getPosition().y);
		if(this.gravityEnable) 
		{			
			Vector2 gravityDirection = (this.planetPosition.cpy().sub(this.getBody().getPosition().cpy())).nor();
			Vector2 bodyGravity = gravityDirection.cpy().scl(this.getBody().getMass() * 98f);
			this.getBody().applyForce(bodyGravity, this.getBody().getWorldCenter(), true);
		}
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

	public boolean isGravityEnable() {
		return gravityEnable;
	}

	public void setGravityEnable(boolean gravityEnable) {
		this.gravityEnable = gravityEnable;
	}

	public float getPlanetMass() {
		return planetMass;
	}

	public void setPlanetMass(float planetMass) {
		this.planetMass = planetMass;
	}

	public Vector2 getPlanetPosition() {
		return planetPosition;
	}

	public void setPlanetPosition(Vector2 planetPosition) {
		this.planetPosition = planetPosition;
	}

	public Vector2 getPlanetWorldCenter() {
		return planetWorldCenter;
	}

	public void setPlanetWorldCenter(Vector2 planetWorldCenter) {
		this.planetWorldCenter = planetWorldCenter;
	}
	
	
}