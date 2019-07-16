// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Pickable;

import java.nio.*;
import java.lang.*;
import java.util.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Pickable extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_11_1();
    }

    public static Pickable getRootAsPickable(ByteBuffer _bb) {
        return getRootAsPickable(_bb, new Pickable());
    }

    public static Pickable getRootAsPickable(ByteBuffer _bb, Pickable obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    public Pickable __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    public short id() {
        int o = __offset(4);
        return o != 0 ? bb.getShort(o + bb_pos) : 0;
    }

    public boolean mutateId(short id) {
        int o = __offset(4);
        if (o != 0) {
            bb.putShort(o + bb_pos, id);
            return true;
        } else {
            return false;
        }
    }

    public String name() {
        int o = __offset(6);
        return o != 0 ? __string(o + bb_pos) : null;
    }

    public ByteBuffer nameAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer nameInByteBuffer(ByteBuffer _bb) {
        return __vector_in_bytebuffer(_bb, 6, 1);
    }

    public SDD.Pickable.Vec2 pos() {
        return pos(new SDD.Pickable.Vec2());
    }

    public SDD.Pickable.Vec2 pos(SDD.Pickable.Vec2 obj) {
        int o = __offset(8);
        return o != 0 ? obj.__assign(o + bb_pos, bb) : null;
    }

    public int durability() {
        int o = __offset(10);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public boolean mutateDurability(int durability) {
        int o = __offset(10);
        if (o != 0) {
            bb.putInt(o + bb_pos, durability);
            return true;
        } else {
            return false;
        }
    }

    public int damage() {
        int o = __offset(12);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public boolean mutateDamage(int damage) {
        int o = __offset(12);
        if (o != 0) {
            bb.putInt(o + bb_pos, damage);
            return true;
        } else {
            return false;
        }
    }

    public short criticalRate() {
        int o = __offset(14);
        return o != 0 ? bb.getShort(o + bb_pos) : 0;
    }

    public boolean mutateCriticalRate(short critical_rate) {
        int o = __offset(14);
        if (o != 0) {
            bb.putShort(o + bb_pos, critical_rate);
            return true;
        } else {
            return false;
        }
    }

    public int combo() {
        int o = __offset(16);
        return o != 0 ? bb.getInt(o + bb_pos) : 0;
    }

    public boolean mutateCombo(int combo) {
        int o = __offset(16);
        if (o != 0) {
            bb.putInt(o + bb_pos, combo);
            return true;
        } else {
            return false;
        }
    }

    public static void startPickable(FlatBufferBuilder builder) {
        builder.startTable(7);
    }

    public static void addId(FlatBufferBuilder builder, short id) {
        builder.addShort(0, id, 0);
    }

    public static void addName(FlatBufferBuilder builder, int nameOffset) {
        builder.addOffset(1, nameOffset, 0);
    }

    public static void addPos(FlatBufferBuilder builder, int posOffset) {
        builder.addStruct(2, posOffset, 0);
    }

    public static void addDurability(FlatBufferBuilder builder, int durability) {
        builder.addInt(3, durability, 0);
    }

    public static void addDamage(FlatBufferBuilder builder, int damage) {
        builder.addInt(4, damage, 0);
    }

    public static void addCriticalRate(FlatBufferBuilder builder, short criticalRate) {
        builder.addShort(5, criticalRate, 0);
    }

    public static void addCombo(FlatBufferBuilder builder, int combo) {
        builder.addInt(6, combo, 0);
    }

    public static int endPickable(FlatBufferBuilder builder) {
        int o = builder.endTable();
        builder.required(o, 8);  // pos
        return o;
    }
}

