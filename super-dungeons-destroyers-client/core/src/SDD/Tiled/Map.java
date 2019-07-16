// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Tiled;

import java.nio.*;
import java.lang.*;
import java.util.*;

import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Map extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_1_11_1();
    }

    public static Map getRootAsMap(ByteBuffer _bb) {
        return getRootAsMap(_bb, new Map());
    }

    public static Map getRootAsMap(ByteBuffer _bb, Map obj) {
        _bb.order(ByteOrder.LITTLE_ENDIAN);
        return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb));
    }

    public void __init(int _i, ByteBuffer _bb) {
        __reset(_i, _bb);
    }

    public Map __assign(int _i, ByteBuffer _bb) {
        __init(_i, _bb);
        return this;
    }

    public int width() {
        int o = __offset(4);
        return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0;
    }

    public boolean mutateWidth(int width) {
        int o = __offset(4);
        if (o != 0) {
            bb.putShort(o + bb_pos, (short) width);
            return true;
        } else {
            return false;
        }
    }

    public int height() {
        int o = __offset(6);
        return o != 0 ? bb.getShort(o + bb_pos) & 0xFFFF : 0;
    }

    public boolean mutateHeight(int height) {
        int o = __offset(6);
        if (o != 0) {
            bb.putShort(o + bb_pos, (short) height);
            return true;
        } else {
            return false;
        }
    }

    public SDD.Tiled.TileLayer layers(int j) {
        return layers(new SDD.Tiled.TileLayer(), j);
    }

    public SDD.Tiled.TileLayer layers(SDD.Tiled.TileLayer obj, int j) {
        int o = __offset(8);
        return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null;
    }

    public int layersLength() {
        int o = __offset(8);
        return o != 0 ? __vector_len(o) : 0;
    }

    public static int createMap(FlatBufferBuilder builder,
                                int width,
                                int height,
                                int layersOffset) {
        builder.startTable(3);
        Map.addLayers(builder, layersOffset);
        Map.addHeight(builder, height);
        Map.addWidth(builder, width);
        return Map.endMap(builder);
    }

    public static void startMap(FlatBufferBuilder builder) {
        builder.startTable(3);
    }

    public static void addWidth(FlatBufferBuilder builder, int width) {
        builder.addShort(0, (short) width, (short) 0);
    }

    public static void addHeight(FlatBufferBuilder builder, int height) {
        builder.addShort(1, (short) height, (short) 0);
    }

    public static void addLayers(FlatBufferBuilder builder, int layersOffset) {
        builder.addOffset(2, layersOffset, 0);
    }

    public static int createLayersVector(FlatBufferBuilder builder, int[] data) {
        builder.startVector(4, data.length, 4);
        for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]);
        return builder.endVector();
    }

    public static void startLayersVector(FlatBufferBuilder builder, int numElems) {
        builder.startVector(4, numElems, 4);
    }

    public static int endMap(FlatBufferBuilder builder) {
        int o = builder.endTable();
        return o;
    }
}

