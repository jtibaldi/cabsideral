package com.game.cabsideral;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.cabsideral.engine.*;
import com.game.cabsideral.screens.*;

public class mGame extends ApplicationAdapter {
	public enum GameState { LogoScreenMaker, LogoScreen, SplashScreenMaker, SplashScreen, MainMenuScreenMaker, MainMenuScreen, GameScreenMaker, GameScreen, CreditsScreenMaker, CreditsScreen }
	public static AssetManager assets;
	
	//Internal collaborators
	private GameState gameState;	
	private SpriteBatch batch;	
	
	//Just for testing	
	private Sprite floatingButtonSprite;  
    private BitmapFont font;  
    
    //Camera and resolution independence
    private VirtualViewport virtualViewport;
    private MultipleVirtualViewportBuilder multipleVirtualViewportBuilder;  
    private OrthographicCameraWithVirtualViewport camera;  
    
    //Screens
    private LogoScreen logoScreen;
    private SplashScreen splashScreen;
    private MainMenuScreen mainMenuScreen;
    private GameScreen gameScreen;
    private CreditsScreen creditsScreen;   
        
	@Override
	public void create () {
		this.multipleVirtualViewportBuilder = new MultipleVirtualViewportBuilder(1920, 1080, 1920, 1536);  
        this.virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera = new OrthographicCameraWithVirtualViewport(virtualViewport);          
        this.camera.position.set(0f, 0f, 0f);
        Gdx.input.setInputProcessor(new InputEngine(this));
        createFloatingUI();
		this.batch = new SpriteBatch();		
		assets = new AssetManager();	//public static
		this.gameState = GameState.LogoScreenMaker;	
	}
	
	public void createFloatingUI() 
	{
		Pixmap pixmap = new Pixmap(64, 64, Format.RGBA8888);  
        pixmap.setColor(Color.WHITE);  
        pixmap.fillRectangle(0, 0, 64, 64);  
        
        floatingButtonSprite = new Sprite(new Texture(pixmap));  
        floatingButtonSprite.setPosition(virtualViewport.getVirtualWidth() * 0.5f - 80, virtualViewport.getVirtualHeight() * 0.5f - 80);  
        floatingButtonSprite.setSize(64, 64);  
        floatingButtonSprite.setColor(1f, 1f, 1f, 1f);        
	}	
	
	@Override  
    public void resize(int width, int height) {  
        super.resize(width, height);            
        VirtualViewport virtualViewport = multipleVirtualViewportBuilder.getVirtualViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());  
        camera.setVirtualViewport(virtualViewport);          
        camera.updateViewport();  
        // centers the camera at 0, 0 (the center of the virtual viewport)  
        camera.position.set(0f, 0f, 0f);          
        // relocate floating stuff
        floatingButtonSprite.setPosition(virtualViewport.getVirtualWidth() * 0.5f - 80, virtualViewport.getVirtualHeight() * 0.5f - 80);          
    }  
	
	public void update(float deltaTime) 
	{
		switch(gameState) 
		{
		case LogoScreenMaker:
			this.logoScreen = new LogoScreen();
			this.gameState = GameState.LogoScreen;
			break;		
		case LogoScreen:
			this.logoScreen.update(deltaTime);
			this.gameState = GameState.SplashScreenMaker; 
			break;
		case SplashScreenMaker: 
			this.splashScreen = new SplashScreen();			
			this.gameState = GameState.SplashScreen;
			break;
		case SplashScreen:
			this.splashScreen.update();
			if(splashScreen.isFinishLoading()) {
				this.gameState = GameState.MainMenuScreenMaker;
			}
			break;
		case MainMenuScreenMaker:
			this.gameState = GameState.MainMenuScreen;
			break;
		case MainMenuScreen:
			this.gameState = GameState.GameScreenMaker;
			break;
		case GameScreenMaker:			
			gameScreen = new GameScreen();			
			font = new BitmapFont();  
	        font.setColor(Color.BLACK);       
	    	this.gameState = GameState.GameScreen;
			break;
		case GameScreen:
			gameScreen.update(deltaTime);			
			break;	
		case CreditsScreenMaker:
			break;
		case CreditsScreen:
			break;
		}		
	}	
	
	@Override
	public void render () {		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update(Gdx.graphics.getDeltaTime());		
		camera.update();  
		Gdx.graphics.setWindowedMode(1280, 720);
		//Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        // render stuff...  
        batch.setProjectionMatrix(camera.combined);  
        batch.begin();
		switch(gameState) 
		{
		case LogoScreenMaker:
			break;			
		case LogoScreen:
			break;	
		case SplashScreenMaker: 
			break;		
		case SplashScreen:				
			break;
		case MainMenuScreenMaker:
			break;
		case MainMenuScreen:
			break;		
		case GameScreenMaker:
			break;	
		case GameScreen:
			gameScreen.draw(batch);
			floatingButtonSprite.draw(batch);  
		    font.draw(batch, String.format("%1$sx%2$s", Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), -20, 0);  
		    break;
		case CreditsScreenMaker:
			break;
		case CreditsScreen:
			break;		        
		}			
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assets.get("buildings/pub/build.png", Texture.class).dispose();
		assets.get("buildings/pub/door.png", Texture.class).dispose();
		assets.get("buildings/pub/doorhole.png", Texture.class).dispose();
		assets.get("buildings/pub/innergravityring.png", Texture.class).dispose();
		assets.get("buildings/pub/outergravityring.png", Texture.class).dispose();
		assets.get("resSop.png",Texture.class).dispose();
		assets.get("character/character.png", Texture.class).dispose();
		assets.get("character/backpack.png", Texture.class).dispose();
		assets.dispose();
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
}