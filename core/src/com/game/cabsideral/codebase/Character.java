package com.game.cabsideral.codebase;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.cabsideral.mGame;

public class Character {
	private int character_width = 50; 
	private int character_height = 80;
	private Sprite characterSprite;
	private Sprite backpackSprite;
		
	public Character() 
	{
		characterSprite = new Sprite(mGame.assets.get("character/character.png",Texture.class));		 
		backpackSprite = new Sprite(mGame.assets.get("character/backpack.png", Texture.class));
		backpackSprite.setPosition(((characterSprite.getX() + characterSprite.getWidth()/2) - (backpackSprite.getWidth()/2)),
								   ((characterSprite.getY() + characterSprite.getHeight()/2) - (backpackSprite.getHeight()/2))); 
	}
	
	public void update(float deltaTime) 
	{		 
		backpackSprite.rotate(1);		
	} 
	
	public void draw(SpriteBatch batch) 
	{
		backpackSprite.draw(batch);
		characterSprite.draw(batch);		
	}
			
}
