package com.slidez;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.slidez.screens.LoadingScreen;
import com.slidez.screens.MainMenuScreen;
import com.slidez.screens.SplashScreen;

public class Application extends Game {

	public static final String TITLE = "Slidez";
	public static final float VERSION = 0.1f;
	public static final int V_WIDTH = 480;
	public static final int V_HEIGHT = 420;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public BitmapFont font24;
	public AssetManager assets;

	public LoadingScreen loadingScreen;
	public SplashScreen splashScreen;
	public MainMenuScreen mainMenuScreen;

	@Override
	public void create () {
		assets = new AssetManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,V_WIDTH,V_HEIGHT);
		batch = new SpriteBatch();

		initFonts();

		loadingScreen = new LoadingScreen(this);
		splashScreen = new SplashScreen(this);
		mainMenuScreen = new MainMenuScreen(this);
		// sets the game screen to a new instances of the Splashscreen object
		this.setScreen(loadingScreen);


	}

	private void initFonts() {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Arcon-Regular.otf"));
		FreeTypeFontGenerator.FreeTypeFontParameter params = new FreeTypeFontGenerator.FreeTypeFontParameter();
		params.size = 24;
		params.color = Color.BLACK;
		font24 = generator.generateFont(params);
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font24.dispose();
		assets.dispose();
		loadingScreen.dispose();
		splashScreen.dispose();
		mainMenuScreen.dispose();
	}
}
