package com.slidez.screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.slidez.Application;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class SplashScreen implements Screen {

    private final Application app;
    private final Stage stage;

    private Image splashImg;

    public SplashScreen(final Application app){
        this.app = app;
        this.stage = new Stage(new StretchViewport(Application.V_WIDTH,Application.V_HEIGHT, app.camera));
        Gdx.input.setInputProcessor(stage);
        Texture splashTex = new Texture(Gdx.files.internal("splash.png"));
        splashImg = new Image(splashTex);
        stage.addActor(splashImg);
    }

    //runs once every time a screen is loaded
    // good for resetting
    @Override
    public void show() {
        System.out.println("Show");
        splashImg.setPosition(stage.getWidth()/2-32,stage.getHeight()/2-32);
        //splashImg.addAction(alpha(.0f));
        //splashImg.addAction(fadeIn(3f));
        //this line does the fancy moving
        splashImg.addAction(sequence(alpha(0),scaleTo(.1f,.1f),
                parallel(fadeIn(2f, Interpolation.pow2),scaleTo(2f,2f,2.5f,Interpolation.pow5),moveTo(stage.getWidth()/2-32,stage.getHeight()/2-32,2f,Interpolation.swing))));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);
        stage.draw();
        app.batch.begin();
        app.font.draw(app.batch,"Splashscreen",120,120);
        app.batch.end();
    }

    public void update(float delta){
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height,false);

    }

    @Override
    public void pause() {
        System.out.println("Pause");

    }

    @Override
    public void resume() {
        System.out.println("Resume");

    }


    //called right before screen is changed
    @Override
    public void hide() {
        System.out.println("Hide");

    }

    @Override
    public void dispose() {
        System.out.println("Dispose");
        stage.dispose();
    }
}