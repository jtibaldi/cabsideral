package com.game.cabsideral.buildings;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.cabsideral.*;
import com.game.cabsideral.codebase.AnimatedSprite;

public class Test {
	private Sprite outerGravityRingSprite;
		
	public Test(float _positionX,float _positionY) {		
		outerGravityRingSprite = new Sprite(mGame.assets.get("buildings/pub/test.png",Texture.class));
		outerGravityRingSprite.setPosition(_positionX,_positionY);
		
	}
	//427*317
	public void update(float deltaTime) {
		
	}
	
	public void draw(SpriteBatch batch) {
		outerGravityRingSprite.draw(batch);				
	}
	public Sprite getOuterGravityRingSprite() {
		return outerGravityRingSprite;
	}
	public void setOuterGravityRingSprite(Sprite outerGravityRingSprite) {
		this.outerGravityRingSprite = outerGravityRingSprite;
	}
}