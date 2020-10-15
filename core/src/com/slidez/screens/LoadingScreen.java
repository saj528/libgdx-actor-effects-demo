package com.slidez.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.slidez.Application;

public class LoadingScreen implements Screen {

    private final Application app;

    private ShapeRenderer shapeRenderer;
    private float progress;


    public LoadingScreen(final Application app){
        this.app = app;
        this.shapeRenderer = new ShapeRenderer();

    }

    private void queueAssets() {
        //adds item to queue to be added to asset manager
        app.assets.load("splash.png", Texture.class);
        app.assets.load("ui/uiskin.atlas", TextureAtlas.class);
    }


    @Override
    public void show() {
        shapeRenderer.setProjectionMatrix(app.camera.combined);
        this.progress = 0f;
        queueAssets();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        update(delta);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(32,app.camera.viewportHeight/2 - 8,app.camera.viewportWidth - 64,16);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(32,app.camera.viewportHeight/2 - 8,progress * (app.camera.viewportWidth - 64),16);
        shapeRenderer.end();

        app.batch.begin();
        app.font24.draw(app.batch,"Screen: LOADING",20,20);
        app.batch.end();
    }

    private void update(float delta) {
        //returns percentage done loading float
        progress = MathUtils.lerp(progress,app.assets.getProgress(),.1f);
        //returns false till all assets are loaded
        if(app.assets.update()){
           app.setScreen(app.mainMenuScreen);
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }



}
