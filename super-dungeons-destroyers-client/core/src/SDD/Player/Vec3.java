// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Player;

import java.nio.*;
import java.lang.*;
import java.util.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Vec3 extends Struct {
    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    public Vec3 __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    public float x() {
        return bb.getFloat(bb_pos + 0);
    }

    public void mutateX(float x) {
        bb.putFloat(bb_pos + 0, x);
    }

    public float y() {
        return bb.getFloat(bb_pos + 4);
    }

    public void mutateY(float y) {
        bb.putFloat(bb_pos + 4, y);
    }

    public float z() {
        return bb.getFloat(bb_pos + 8);
    }

    public void mutateZ(float z) {
        bb.putFloat(bb_pos + 8, z);
    }

    public static int createVec3(FlatBufferBuilder builder, float x, float y, float z) {
        builder.prep(4, 12);
        builder.putFloat(z);
        builder.putFloat(y);
        builder.putFloat(x);
        return builder.offset();
    }
}

