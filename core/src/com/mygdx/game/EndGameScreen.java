package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class EndGameScreen implements Screen {
    final Drop game;
    OrthographicCamera camera;
    Texture background;
    int toothpickCollected;
    EndGameScreen(final Drop gam, int toothpickCollected){
        game = gam;
        this.toothpickCollected = toothpickCollected;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 750);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        if (this.toothpickCollected >= 70){
            background = new Texture("pictures/good.jpg");
        } else {
            background = new Texture("pictures/bad.png");
        }
        game.batch.draw(background, 0, 0);
        game.batch.end();
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }

    }
    @Override
    public void show() {

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
