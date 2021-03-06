package org.salondesdevs.superdungeonsdestroyers.library.packets.fromclient;

import io.netty.buffer.ByteBuf;
import org.salondesdevs.superdungeonsdestroyers.library.chat.ChatChannel;
import org.salondesdevs.superdungeonsdestroyers.library.chat.ChatMessage;
import org.salondesdevs.superdungeonsdestroyers.library.packets.Packet;

public class FromClientChat extends Packet {
    private ChatMessage chatMessage;
    private ChatChannel chatChannel;

    public FromClientChat() {
    }

    public FromClientChat(ChatMessage chatMessage, ChatChannel chatChannel) {
        this.chatMessage = chatMessage;
        this.chatChannel = chatChannel;
    }

    @Override
    public void read(ByteBuf in) {
        this.chatMessage = new ChatMessage();
        this.chatMessage.read(in);
        this.chatChannel = readEnum(ChatChannel.class, in);
    }

    @Override
    public void write(ByteBuf out) {
        this.chatMessage.write(out);
        writeEnum(this.chatChannel, out);
    }

    public ChatMessage getChatMessage() {
        return chatMessage;
    }

    public ChatChannel getChatChannel() {
        return chatChannel;
    }
}
