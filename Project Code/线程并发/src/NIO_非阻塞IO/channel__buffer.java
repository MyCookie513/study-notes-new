package NIO_������IO;



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
        	//����ط���ʾ��ͨ���ж�ȡ�˶��ٸ��ֽڵ����ݣ������ȡ��������᷵��-1��
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
        // ��ʱposition=0,limit=capacity
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        while (true) {
            // readǰ��position=0��limit=3
            int n = inChannel.read(byteBuffer);
            // read��position=3��limit=3
            System.out.println("n = " + n);
            if (n == -1) {
                break;
            }
            // flip��position=0��limit=3������3��֮��position=0,limit=1,��Ϊ���ֻ��1��Ԫ��
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            // clear()��position=0, limit=3;������һ�ζ�ȡʹ��buffer
            byteBuffer.clear();
            while (byteBuffer.hasRemaining()) {
                System.out.println("read : " + byteBuffer.get());
            }
            byteBuffer.clear();
        }
 
        // ����������ķ�ʽ�⣬����һ������ݵķ�����transferTo,transferFrom
        //inChannel.transferTo(0, inChannel.size(), outChannel);
        // ������
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        
    }

}
