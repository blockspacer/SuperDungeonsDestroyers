// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Dungeon;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Dungeon extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_11_1(); }
  public static Dungeon getRootAsDungeon(ByteBuffer _bb) { return getRootAsDungeon(_bb, new Dungeon()); }
  public static Dungeon getRootAsDungeon(ByteBuffer _bb, Dungeon obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Dungeon __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public SDD.Dungeon.Room rooms(int j) { return rooms(new SDD.Dungeon.Room(), j); }
  public SDD.Dungeon.Room rooms(SDD.Dungeon.Room obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int roomsLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }

  public static int createDungeon(FlatBufferBuilder builder,
      int roomsOffset) {
    builder.startTable(1);
    Dungeon.addRooms(builder, roomsOffset);
    return Dungeon.endDungeon(builder);
  }

  public static void startDungeon(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addRooms(FlatBufferBuilder builder, int roomsOffset) { builder.addOffset(0, roomsOffset, 0); }
  public static int createRoomsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startRoomsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endDungeon(FlatBufferBuilder builder) {
    int o = builder.endTable();
    builder.required(o, 4);  // rooms
    return o;
  }
  public static void finishDungeonBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedDungeonBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }
}

