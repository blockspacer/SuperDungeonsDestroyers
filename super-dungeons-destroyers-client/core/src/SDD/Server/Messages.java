// automatically generated by the FlatBuffers compiler, do not modify

package SDD.Server;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Messages extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_11_1(); }
  public static Messages getRootAsMessages(ByteBuffer _bb) { return getRootAsMessages(_bb, new Messages()); }
  public static Messages getRootAsMessages(ByteBuffer _bb, Messages obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Messages __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public SDD.Server.Message messages(int j) { return messages(new SDD.Server.Message(), j); }
  public SDD.Server.Message messages(SDD.Server.Message obj, int j) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int messagesLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }

  public static int createMessages(FlatBufferBuilder builder,
      int messagesOffset) {
    builder.startTable(1);
    Messages.addMessages(builder, messagesOffset);
    return Messages.endMessages(builder);
  }

  public static void startMessages(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addMessages(FlatBufferBuilder builder, int messagesOffset) { builder.addOffset(0, messagesOffset, 0); }
  public static int createMessagesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startMessagesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endMessages(FlatBufferBuilder builder) {
    int o = builder.endTable();
    builder.required(o, 4);  // messages
    return o;
  }
  public static void finishMessagesBuffer(FlatBufferBuilder builder, int offset) { builder.finish(offset); }
  public static void finishSizePrefixedMessagesBuffer(FlatBufferBuilder builder, int offset) { builder.finishSizePrefixed(offset); }
}

