// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Player;

import java.nio.*;
import java.lang.*;
import java.util.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Player extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_11_1();
    }

    public static Player getRootAsPlayer(ByteBuffer _bb) {
        return getRootAsPlayer(_bb, new Player());
    }

    public static Player getRootAsPlayer(ByteBuffer _bb, Player obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    public Player __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    public String name() {
        int o = __offset(4);
        return o != 0 ? __string(o + bb_pos) : null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer _bb) {
        return __vector_in_bytebuffer(_bb, 4, 1);
    }

    public SDD.Player.Vec3 location() {
        return location(new SDD.Player.Vec3());
    }

    public SDD.Player.Vec3 location(SDD.Player.Vec3 obj) {
        int o = __offset(6);
        return o != 0 ? obj.__assign(o + bb_pos, bb) : null;
    }

    public static void startPlayer(FlatBufferBuilder builder) {
        builder.startTable(2);
    }

    public static void addName(FlatBufferBuilder builder, int nameOffset) {
        builder.addOffset(0, nameOffset, 0);
    }

    public static void addLocation(FlatBufferBuilder builder, int locationOffset) {
        builder.addStruct(1, locationOffset, 0);
    }

    public static int endPlayer(FlatBufferBuilder builder) {
        int o = builder.endTable();
        builder.required(o, 4);  // name
        builder.required(o, 6);  // location
        return o;
    }
}

