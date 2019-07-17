package org.salondesdevs.superdungeonsdestroyers.systems.ingame;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.wytrem.ecs.*;
import org.salondesdevs.superdungeonsdestroyers.components.Position;
import org.salondesdevs.superdungeonsdestroyers.components.Sprited;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SpriteRenderer extends IteratingSystem {
    public SpriteRenderer() {
        super(Aspect.all(Sprited.class, Position.class));
    }

    @Override
    public void initialize() {
        batch = new SpriteBatch();
    }

    SpriteBatch batch;

    @Inject
    Mapper<Sprited> spritedMapper;

    @Inject
    Mapper<Position> positionMapper;

    @Inject
    CameraService cameraService;

    @Override
    public void begin() {
        batch.setProjectionMatrix(cameraService.camera.combined);
        batch.begin();
    }

    @Override
    public void process(int entity) {
        Sprited sprited = spritedMapper.get(entity);
        Position position = positionMapper.get(entity);

        batch.draw(sprited.textureRegion, position.x * 16, position.y * 16);
    }

    @Override
    public void end() {
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
