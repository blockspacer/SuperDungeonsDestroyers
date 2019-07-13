package org.salondesdevs.superdungeonsdestroyers.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.IntArray;
import net.wytrem.ecs.*;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class InputSystem extends BaseSystem implements InputProcessor {

    IntArray keys;

    @Inject
    CameraService cameraService;

    @Override
    public void initialize() {
        keys = new IntArray();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void process() {
        //TODO: this is temporary
        if (keys.contains(Input.Keys.UP)) {
            cameraService.camera.position.y += 0.5f;
            cameraService.camera.update();
        }
        if (keys.contains(Input.Keys.DOWN)) {
            cameraService.camera.position.y -= 0.5f;
            cameraService.camera.update();
        }
        if (keys.contains(Input.Keys.LEFT)) {
            cameraService.camera.position.x -= 0.5f;
            cameraService.camera.update();
        }
        if (keys.contains(Input.Keys.RIGHT)) {
            cameraService.camera.position.x += 0.5f;
            cameraService.camera.update();
        }
    }

    @Override
    public boolean keyDown(int keycode) {
        keys.add(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        keys.removeValue(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
