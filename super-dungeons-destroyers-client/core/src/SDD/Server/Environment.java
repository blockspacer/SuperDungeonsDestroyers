// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Server;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Environment extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_11_1(); }
  public static Environment getRootAsEnvironment(ByteBuffer _bb) { return getRootAsEnvironment(_bb, new Environment()); }
  public static Environment getRootAsEnvironment(ByteBuffer _bb, Environment obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Environment __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public SDD.Common.Level level() { return level(new SDD.Common.Level()); }
  public SDD.Common.Level level(SDD.Common.Level obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  public SDD.Common.Entity entities(int j) { return entities(new SDD.Common.Entity(), j); }
  public SDD.Common.Entity entities(SDD.Common.Entity obj, int j) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int entitiesLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }

  public static int createEnvironment(FlatBufferBuilder builder,
      int levelOffset,
      int entitiesOffset) {
    builder.startTable(2);
    Environment.addEntities(builder, entitiesOffset);
    Environment.addLevel(builder, levelOffset);
    return Environment.endEnvironment(builder);
  }

  public static void startEnvironment(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addLevel(FlatBufferBuilder builder, int levelOffset) { builder.addOffset(0, levelOffset, 0); }
  public static void addEntities(FlatBufferBuilder builder, int entitiesOffset) { builder.addOffset(1, entitiesOffset, 0); }
  public static int createEntitiesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startEntitiesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endEnvironment(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
}

