package jfr.parser.leb128;

import java.nio.*;

/**
 * chenmudu@gmail.com
 *
 * LEB128-Compressed VarShort, VarInt, VarLong.
 */
public class Leb128CompressedByteBuffer {

    private static final int SEGMENT_BITS = 0x7F;

    private static final int CONTINUE_BIT = 0x80;

    private final ByteBuffer buffer;

    public Leb128CompressedByteBuffer (final ByteBuffer buffer) {
        this.buffer = buffer;
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


    /**
     *
     * @return
     */
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
            if (position >= 32) {
                throw new RuntimeException("VarInt is too big!");
            }
        }
        return result;
    }

    /**
     *
     * @return
     */
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

            if (position >= 64) {
                throw new RuntimeException("VarLong is too big!");
            }
        }

        return result;
    }

    /**
     *
     * @return
     */
    public short getVarShort(byte b) {
        byte[] bytes = new byte[getVarInt()];
        buffer.get(bytes);
        return Short.parseShort(String.valueOf(bytes));
    }

    public String getString() {
        return null;
    }
}
