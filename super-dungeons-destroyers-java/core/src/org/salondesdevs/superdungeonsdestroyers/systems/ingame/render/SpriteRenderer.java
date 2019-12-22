package org.salondesdevs.superdungeonsdestroyers.systems.ingame.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.wytrem.ecs.*;
import org.salondesdevs.superdungeonsdestroyers.library.components.Position;
import org.salondesdevs.superdungeonsdestroyers.components.Sprited;
import org.salondesdevs.superdungeonsdestroyers.utils.Constants;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class SpriteRenderer extends IteratingSystem {
    public SpriteRenderer() {
        super(Aspect.all(Sprited.class, Position.class));
    }

    @Override
    public void initialize() {
        batch = new GridSpriteBatch();
    }

    GridSpriteBatch batch;

    @Inject
    Mapper<Sprited> spritedMapper;

    @Inject
    Mapper<Position> positionMapper;

    @Inject
    CameraSystem cameraService;

    @Override
    public void begin() {
        batch.setProjectionMatrix(cameraService.camera.combined);
        batch.begin();
    }

    @Override
    public void process(int entity) {
        Sprited sprited = spritedMapper.get(entity);
        Position position = positionMapper.get(entity);

        batch.draw(sprited.textureRegion, position);
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
