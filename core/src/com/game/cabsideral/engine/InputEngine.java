package com.game.cabsideral.engine;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.game.cabsideral.mGame;

public class InputEngine implements InputProcessor{
	private mGame game;
		
	public InputEngine(mGame _game) 
	{
		game = _game; 		
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.RIGHT)			
			game.getGameScreen().getCharacter().getBody().setLinearVelocity(100f, 0f);
		if(keycode == Input.Keys.LEFT)	
			game.getGameScreen().getCharacter().getBody().setLinearVelocity(-100f,0f);
		if(keycode == Input.Keys.UP)
			game.getGameScreen().getCharacter().getBody().setLinearVelocity(0f,300f);
		if(keycode == Input.Keys.SPACE) {
			game.getGameScreen().getCharacter().getBody().setLinearVelocity(0f, 0f);
			game.getGameScreen().getCharacter().getBody().setAngularVelocity(0f);	
		}
		return true;
	}	
	
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}