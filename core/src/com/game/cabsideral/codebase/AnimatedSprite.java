package com.game.cabsideral.codebase;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimatedSprite {	
	
	Texture spriteSheet;
	int FRAME_COLS;
	int FRAME_ROWS;
	TextureRegion[] animationFrames;    
    TextureRegion frame;
    
    public AnimatedSprite(Texture _spriteSheet, int _FRAME_COLS, int _FRAME_ROWS)
	{    	
		FRAME_COLS = _FRAME_COLS;
		FRAME_ROWS = _FRAME_ROWS;
		spriteSheet = _spriteSheet; 
    	TextureRegion[][] tmp = TextureRegion.split(spriteSheet, spriteSheet.getWidth()/FRAME_COLS, spriteSheet.getHeight()/FRAME_ROWS);              
        animationFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }      
    }
    //Getters y Setters
	public Texture getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(Texture spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public TextureRegion[] getAnimationFrames() {
		return animationFrames;
	}

	public void setAnimationFrames(TextureRegion[] animationFrames) {
		this.animationFrames = animationFrames;
	}

	public TextureRegion getFrame() {
		return frame;
	}

	public void setFrame(TextureRegion frame) {
		this.frame = frame;		
	}    
}
