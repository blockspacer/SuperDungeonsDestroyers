package org.salondesdevs.superdungeonsdestroyers.systems.common.ui.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import org.salondesdevs.superdungeonsdestroyers.library.events.EventHandler;
import com.kotcrab.vis.ui.widget.VisImage;
import com.kotcrab.vis.ui.widget.VisLabel;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisTextField;
import net.wytrem.ecs.World;
import org.salondesdevs.superdungeonsdestroyers.events.ConnectFailedEvent;
import org.salondesdevs.superdungeonsdestroyers.events.ConnectSucceedEvent;
import org.salondesdevs.superdungeonsdestroyers.library.packets.fromclient.PlayerName;
import org.salondesdevs.superdungeonsdestroyers.library.packets.fromserver.VersionCheckSuccess;
import org.salondesdevs.superdungeonsdestroyers.systems.common.Assets;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkHandlerSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.NetworkSystem;
import org.salondesdevs.superdungeonsdestroyers.systems.common.network.PacketReceivedEvent;
import org.salondesdevs.superdungeonsdestroyers.systems.common.ui.UiSystem;

import javax.inject.Inject;

public class MainMenuScreen extends Screen {

    @Inject
    Assets assets;

    @Inject
    World world;

    @Inject
    NetworkSystem networkSystem;

    @Inject
    NetworkHandlerSystem networkHandlerSystem;

    @Inject
    I18NService i18NService;

    @Inject
    UiSystem uiSystem;

    private VisLabel errorLabel;
    private VisTextField nameField;

    @Inject
    protected void addActors() {
        Table table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(assets.titleBackground)));
        table.center();
        table.setFillParent(true);

        VerticalGroup verticalGroup = new VerticalGroup().space(80f);
        table.add(verticalGroup);
        stage.addActor(table);

        VisImage image = new VisImage(assets.title);
        verticalGroup.addActor(image);

        VerticalGroup buttons = new VerticalGroup();
        buttons.space(10f);
        {
            nameField = new VisTextField("nickname");
            buttons.addActor(nameField);

            VisTextField serverIp = new VisTextField("localhost");
            buttons.addActor(serverIp);

            VisTextButton textButton = new VisTextButton(i18NService.get("connectToServer"));
            buttons.addActor(textButton);

            errorLabel = new VisLabel("");
            errorLabel.setColor(Color.RED);
            buttons.addActor(errorLabel);

            textButton.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    String text = serverIp.getText();
                    if (text.length() > 0) {
                        String ip = text;
                        int port = 9000;

                        if (ip.contains(":")) {
                            String[] split = ip.split(":");
                            ip = split[0];

                            port = Integer.parseInt(split[1]);
                        }

                        networkSystem.tryConnectToServer(ip, port);
                    }
                }
            });
        }

        verticalGroup.addActor(buttons);
    }

    @EventHandler
    public void onPacketReceived(PacketReceivedEvent packetReceivedEvent) {
        if (packetReceivedEvent.getPacket() instanceof VersionCheckSuccess) {
              networkSystem.send(new PlayerName(this.getNickname()));
              uiSystem.displayScreen(null);
        }
    }


    @EventHandler
    public void onConnectSucceed(ConnectSucceedEvent connectSucceedEvent) {
            errorLabel.setText("");
    }

    @EventHandler
    public void onConnectFailed(ConnectFailedEvent connectFailedEvent) {
        Throwable t = connectFailedEvent.getCause();

        if (t != null) {
            errorLabel.setText(i18NService.format("couldNotConnect", t.getLocalizedMessage()));
        }
        else {
            errorLabel.setText(i18NService.format("couldNotConnect", "null throwable"));
        }
    }

    public String getNickname() {
        return nameField.getText().isEmpty() ? "Nick" + Math.random() : nameField.getText();
    }
}
