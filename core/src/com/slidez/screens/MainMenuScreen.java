package com.slidez.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.slidez.Application;

public class MainMenuScreen implements Screen {

    private Application app;
    private Stage stage;
    private ShapeRenderer shapeRenderer;

    public MainMenuScreen(final Application app){
        this.app = app;
        this.stage = new Stage(new StretchViewport(Application.V_WIDTH,Application.V_HEIGHT, app.camera));
        this.shapeRenderer = new ShapeRenderer();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        app.batch.begin();
        app.font24.draw(app.batch,"Screen: MainMenu",20,20);
        app.batch.end();
    }

    private void update(float delta) {
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

    }
}
