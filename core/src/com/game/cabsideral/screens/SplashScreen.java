package com.game.cabsideral.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.game.cabsideral.mGame;

public class SplashScreen extends Screen {
	private boolean finishLoading = false;	
	
	public SplashScreen() 
	{
		this.loadAssets();
	}
	
	public void update() 
	{
		if(mGame.assets.update()) 
		{
			this.applyFiltersToAssets();	
			finishLoading = true;
		}
	}
	
	public void loadAssets() 
	{
		mGame.assets.load("buildings/pub/build.png", Texture.class);
		mGame.assets.load("buildings/pub/door.png", Texture.class);
		mGame.assets.load("buildings/pub/doorhole.png", Texture.class);
		mGame.assets.load("buildings/pub/gravityring.png", Texture.class);
		mGame.assets.load("resSop.png",Texture.class);
		mGame.assets.load("character/character.png", Texture.class);
		mGame.assets.load("character/backpack.png", Texture.class);		
	}
	
	public void applyFiltersToAssets() 
	{
		mGame.assets.get("buildings/pub/build.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("buildings/pub/door.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("buildings/pub/doorhole.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("buildings/pub/gravityring.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("resSop.png",Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("character/character.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
		mGame.assets.get("character/backpack.png", Texture.class).setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	public boolean isFinishLoading() {
		return finishLoading;
	}

	public void setFinishLoading(boolean finishLoading) {
		this.finishLoading = finishLoading;
	}
	
	
}
