package jfr.parser.leb128;

import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * chenmudu@gmail.com
 *
 * LEB128-Compressed VarShort, VarInt, VarLong.
 */
public class Leb128CompressedByteBuffer {

    private static Leb128CompressedByteBuffer INSTANCE;

    private static final int SEGMENT_BITS = 0x7F;

    private static final int CONTINUE_BIT = 0x80;

    private final ByteBuffer buffer;

    public static Leb128CompressedByteBuffer getLeb128CompressedByteBuffer(ByteBuffer buffer) {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Leb128CompressedByteBuffer(buffer);
        }
        return INSTANCE;
    }

    public Leb128CompressedByteBuffer (final ByteBuffer buffer) {
        this.buffer = buffer;
        this.buffer.order(ByteOrder.BIG_ENDIAN);
    }

    public byte get() {
        return buffer.get();
    }

    public byte get(int index) {
        return buffer.get(index);
    }

    public char getChar() {
        return buffer.getChar();
    }

    public char getChar(int index) {
        return buffer.getChar(index);
    }

    public short getShort() {
        return buffer.getShort();
    }

    public short getShort(int index) {
        return buffer.getShort(index);
    }

    public int getInt() {
        return buffer.getInt();
    }

    public int getInt(int index) {
        return buffer.getInt(index);
    }


    public long getLong() {
        return buffer.getLong();
    }

    public long getLong(int index) {
        return buffer.getLong(index);
    }

    public float getFloat() {
        return buffer.getFloat();
    }

    public float getFloat(int index) {
        return buffer.getFloat(index);
    }


    public double getDouble() {
        return buffer.getDouble();
    }

    public double getDouble(int index) {
        return buffer.getDouble(index);
    }



    public int getVarInt() {
        int result = 0;
        int position = 0;
        while (true) {
            byte b = buffer.get();
            result |= (b & SEGMENT_BITS) << position;
            if ((b & CONTINUE_BIT) == 0) {
                break;
            }
            position += 7;
            //0 + 4 * 7 ==> 5. current byte count ==> [1, 5]
            if (position > 28) {
                throw new RuntimeException("VarInt is too big!");
            }
        }
        return result;
    }


    public long getVarLong() {
        int result = 0;
        int position = 0;
        while (true) {
            byte b = buffer.get();
            result |= (long) (b & SEGMENT_BITS) << position;

            if ((b & CONTINUE_BIT) == 0) {
                break;
            }
            position += 7;
            //0 + 9 * 7 ==> 10. current byte count ==> [1, 10]
            if (position > 63) {
                throw new RuntimeException("VarLong is too big!");
            }
        }

        return result;
    }


    public short getVarShort() {
        short result = 0;
        int position = 0;

        while(true) {
            byte b = buffer.get();
            result |= (short)((b & 0x7F) << position);
            if ((b & 0x80) == 0) {
                break;
            }
            position += 7;
            //0 + 2 * 7 ==> 3. current byte count ==> [1, 2]
            if (position > 14) {
                throw new RuntimeException("Varshort is too long");
            }
        }

        return result;
    }

    /**
     * notice: null != ""
     * @return
     */
    public String getString() {
        switch (buffer.get()) {
            case 0:
                return null;
            case 1:
                return "";
            case 3:
                //constant pool.
                return new String(getBytes(), StandardCharsets.UTF_8);
            case 4: {
                //char array.
                char[] chars = new char[getVarInt()];
                for (int i = 0; i < chars.length; i++) {
                    chars[i] = (char) getVarInt();
                }
                return new String(chars);
            }
            case 5:
                //latin1 byte array.
                return new String(getBytes(), StandardCharsets.ISO_8859_1);
            default:
                throw new IllegalArgumentException("Invalid string encoding");
        }
    }

    private byte[] getBytes() {
        byte[] bytes = new byte[getVarInt()];
        buffer.get(bytes);
        return bytes;
    }
}
