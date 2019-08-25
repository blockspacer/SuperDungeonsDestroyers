package org.salondesdevs.superdungeonsdestroyers.server.systems;

import net.wytrem.ecs.*;
import org.salondesdevs.superdungeonsdestroyers.library.components.Direction;
import org.salondesdevs.superdungeonsdestroyers.library.components.EntityKind;
import org.salondesdevs.superdungeonsdestroyers.library.components.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/**
 * Performs all the operations on {@link Component}s end entities that need to be shared with clients.
 */
public class EnvironmentManager extends Service {

    private static final Logger logger = LoggerFactory.getLogger( EnvironmentManager.class );

    @Inject
    Mapper<Position> positionMapper;

    @Inject
    Synchronizer synchronizer;

    @Inject
    EntityCreator entityCreator;

    public void moveEntity(int entity, Direction direction) {
        if (positionMapper.has(entity)) {
            positionMapper.get(entity).increment(direction);
            synchronizer.notifyEntityMoved(entity, direction);
        }
        else {
            logger.warn("Tried to move {} in direction {}, but it has no position.", entity, direction.name());
        }
    }

    public int spawn(EntityKind entityKind) {
        int spawned = entityCreator.create(entityKind);
        synchronizer.notifyEntitySpawned(spawned, entityKind);
        return spawned;
    }

    public void teleport(int entity, int x, int y) {
        if (positionMapper.has(entity)) {
            Position position = positionMapper.get(entity);
            if (position.x != x || position.y != y) {
                position.x = x;
                position.y = y;
                synchronizer.notifyPositionChanged(entity, x, y);
            }
        }
        else {
            logger.warn("Tried to teleport {} to ({},{}), but it has no position.", entity, x, y);
        }
    }
}