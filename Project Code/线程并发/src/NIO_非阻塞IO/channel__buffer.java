package NIO_非阻塞IO;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
 
public class channel__buffer {
    public static void main(String[] args) {
        try {
        	testCopyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
 
    private static void testWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("testNIO.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for (int i=0 ;i<10; i++) {
            byteBuffer.put((byte)i);
            System.out.println("write : " + (byte)i);
        }
        byteBuffer.flip();
        channel.write(byteBuffer);
 
        fos.close();
 
    }
 
    private static void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("testNIO.txt");


        FileChannel fileChannel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
        	//这个地方表示从通道中读取了多少个字节的数据，如果读取不到，则会返回-1；
            int n = fileChannel.read(byteBuffer);
            System.out.println("read..."+n);
            if (n == -1) {
                break;
            }
 
        }
        byteBuffer.flip();
 
        while (byteBuffer.hasRemaining()) {
            System.out.println("read : " + byteBuffer.get());
        }
 
        fis.close();
    }

private static void testCopyFile() throws IOException {
        FileInputStream fis = new FileInputStream("testNIO.txt");
        FileOutputStream fos = new FileOutputStream("testNIOCopy.txt");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        // 此时position=0,limit=capacity
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        while (true) {
            // read前，position=0，limit=3
            int n = inChannel.read(byteBuffer);
            // read后，position=3，limit=3
            System.out.println("n = " + n);
            if (n == -1) {
                break;
            }
            // flip后，position=0，limit=3，经过3次之后，position=0,limit=1,因为这次只读1个元素
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            // clear()把position=0, limit=3;方便下一次读取使用buffer
            byteBuffer.clear();
            while (byteBuffer.hasRemaining()) {
                System.out.println("read : " + byteBuffer.get());
            }
            byteBuffer.clear();
        }
 
        // 除了用上面的方式外，还有一个更快捷的方法：transferTo,transferFrom
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        // 或者是
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        
    }

}
