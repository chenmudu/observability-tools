
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestRun {

    private static FileChannel fileChannel;

    private static ByteBuffer byteBuffer;

    private static Integer BUFFER_SIZE = 1024;//1kb

    private static byte[] nullByteArr = "null".getBytes();

    private static long  filePosition;


    private static void init(String filePath) throws IOException {
        fileChannel = FileChannel.open(Paths.get(java.lang.String.valueOf(filePath)), StandardOpenOption.READ);
        byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        printBufferProperties(byteBuffer);
        fileChannel.read(byteBuffer);
        printBufferProperties(byteBuffer);
        byteBuffer.flip();
        printBufferProperties(byteBuffer);
    }


    private final static String FILE_PATH_JFR = "";

    private final static String FILE_PATH_TXT = "";

    public static void main(String[] args) throws IOException {
        try {
            init(FILE_PATH_TXT);
            while(byteBuffer.position() < byteBuffer.limit()) {
                System.out.print(new String(new byte[]{byteBuffer.get()}));
            }
            System.out.println();
        } catch (Exception e) {
            throw e;
        } finally {
            fileChannel.close();
        }
    }



    private static void printBufferProperties(ByteBuffer buffer)  {
        System.out.printf("position: %d, limit: %d, capacity: %d\n",
                buffer.position(), buffer.limit(), buffer.capacity());
    }
}
