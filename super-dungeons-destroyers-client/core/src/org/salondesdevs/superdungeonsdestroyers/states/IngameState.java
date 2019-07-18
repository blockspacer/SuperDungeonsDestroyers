package org.salondesdevs.superdungeonsdestroyers.states;

import net.wytrem.ecs.*;
import org.salondesdevs.superdungeonsdestroyers.systems.common.Assets;
import org.salondesdevs.superdungeonsdestroyers.systems.common.ClearScrenSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkHandlerSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.AnimatedSpriteRenderer;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.CameraSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.GroundRenderSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.IngameNetHandler;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.InputSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.LevelSwitcher;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.OverlayRenderSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.SpriteRenderer;

import javax.inject.Inject;

public class IngameState extends GameState {
    @Inject
    World world;

    @Inject
    NetworkHandlerSystem networkHandlerSystem;


    public IngameState() {
        super();

        // Be aware, the order matters.
        register(Assets.class);
        register(NetworkSystem.class);
        register(NetworkHandlerSystem.class);
        register(LevelSwitcher.class);
        register(CameraSystem.class);
        register(ClearScrenSystem.class);
        register(GroundRenderSystem.class);
        register(SpriteRenderer.class);
        register(AnimatedSpriteRenderer.class);
        register(OverlayRenderSystem.class);
        register(InputSystem.class);
    }

    @Override
    public void pushed() {
        this.networkHandlerSystem.setCurrentHandler(IngameNetHandler.class);
    }
}
