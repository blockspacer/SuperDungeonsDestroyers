package org.salondesdevs.superdungeonsdestroyers.states;

import org.salondesdevs.superdungeonsdestroyers.systems.common.Assets;
import org.salondesdevs.superdungeonsdestroyers.systems.common.ClearScrenSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.animations.Animator;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkHandlerSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.ui.UiSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.EntityCreator;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.logic.PlayerIdHolder;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.logic.PlayerMotionSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.render.AnimatedSpriteRenderer;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.render.CameraSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.render.GroundRenderer;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.IngameNetHandler;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.IngameInputSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.LevelSwitcher;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.render.OverlayRenderer;
import org.salondesdevs.superdungeonsdestroyers.systems.ingame.render.SpriteRenderer;

import javax.inject.Inject;

public class IngameState extends SDDState {
    @Inject
    NetworkHandlerSystem networkHandlerSystem;


    public IngameState() {
        super();

        // Be aware, the order matters.

        // Services
        register(Assets.class);
        register(EntityCreator.class);

        // Network stuff
        register(NetworkSystem.class);
        register(NetworkHandlerSystem.class);

        // Input
        register(IngameInputSystem.class);
        register(PlayerMotionSystem.class);

        // Updating stuff
        register(LevelSwitcher.class);
        register(Animator.class);
        register(PlayerIdHolder.class);

        // Rendering stuff
        register(CameraSystem.class);
        register(ClearScrenSystem.class);
        register(GroundRenderer.class);
        register(SpriteRenderer.class);
        register(AnimatedSpriteRenderer.class);
        register(OverlayRenderer.class);
        register(UiSystem.class);
    }

    @Inject
    UiSystem uiSystem;

    @Override
    public void pushed() {
        super.pushed();

        uiSystem.displayScreen(null);

        this.networkHandlerSystem.setCurrentHandler(IngameNetHandler.class);
    }
}
