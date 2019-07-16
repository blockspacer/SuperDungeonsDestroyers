// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Server;

import java.nio.*;
import java.lang.*;
import java.util.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Message extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_11_1();
    }

    public static Message getRootAsMessage(ByteBuffer _bb) {
        return getRootAsMessage(_bb, new Message());
    }

    public static Message getRootAsMessage(ByteBuffer _bb, Message obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    public Message __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    public byte contentType() {
        int o = __offset(4);
        return o != 0 ? bb.get(o + bb_pos) : 0;
    }

    public boolean mutateContentType(byte content_type) {
        int o = __offset(4);
        if (o != 0) {
            bb.put(o + bb_pos, content_type);
            return true;
        } else {
            return false;
        }
    }

    public Table content(Table obj) {
        int o = __offset(6);
        return o != 0 ? __union(obj, o) : null;
    }

    public static int createMessage(FlatBufferBuilder builder,
                                    byte content_type,
                                    int contentOffset) {
        builder.startTable(2);
        Message.addContent(builder, contentOffset);
        Message.addContentType(builder, content_type);
        return Message.endMessage(builder);
    }

    public static void startMessage(FlatBufferBuilder builder) {
        builder.startTable(2);
    }

    public static void addContentType(FlatBufferBuilder builder, byte contentType) {
        builder.addByte(0, contentType, 0);
    }

    public static void addContent(FlatBufferBuilder builder, int contentOffset) {
        builder.addOffset(1, contentOffset, 0);
    }

    public static int endMessage(FlatBufferBuilder builder) {
        int o = builder.endTable();
        return o;
    }
}

