package com.slidez.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.slidez.Application;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class MainMenuScreen implements Screen {

    private Application app;
    private Stage stage;
    private Skin skin;
    private TextButton buttonPlay,buttonExit;
    private ShapeRenderer shapeRenderer;

    public MainMenuScreen(final Application app){
        this.app = app;
        this.stage = new Stage(new StretchViewport(Application.V_WIDTH,Application.V_HEIGHT, app.camera));
        this.shapeRenderer = new ShapeRenderer();


    }
    @Override
    public void show() {
        System.out.println("MAIN MENU");
        Gdx.input.setInputProcessor(stage);
        stage.clear();

        this.skin = new Skin();
        this.skin.addRegions(app.assets.get("ui/uiskin.atlas", TextureAtlas.class));
        this.skin.add("default-font",app.font24);
        this.skin.load(Gdx.files.internal("ui/uiskin.json"));
        initButtons();
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
        stage.act();
        stage.draw();
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

    private void initButtons() {
        buttonPlay = new TextButton("Play",skin,"default");
        buttonPlay.setPosition(110,260);
        buttonPlay.setSize(280,60);
        buttonPlay.addAction(sequence(alpha(0),parallel(fadeIn(.5f),moveBy(0,-20,.5f, Interpolation.pow5Out))));
        buttonPlay.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                app.setScreen(app.playScreen);
            }
        });


        buttonExit = new TextButton("Exit",skin,"default");
        buttonExit.setPosition(110,190);
        buttonExit.setSize(280,60);
        buttonExit.addAction(sequence(alpha(0),parallel(fadeIn(.5f),moveBy(0,-20,.5f, Interpolation.pow5Out))));
        buttonExit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        stage.addActor(buttonPlay);
        stage.addActor(buttonExit);
    }
}
