package NIO.test_FileChannel_and_bytebuffer;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
 
public class channel__buffer {
    public static void main(String[] args)throws IOException  {



        try {
            //testWrite();
            //testRead();
        	testCopyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试在缓存中放入字节，
     * 然后再生成的文件通道中写入到文件中
     * @throws IOException
     */
    private static void testWrite() throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\testNIO.txt");
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

    /**从文件中得到一个文件通道然后
     * 将从通道中读取的数据放入到缓存中，
     * 再从缓存中读取出来
     *
     *
     * @throws IOException
     */
    private static void testRead() throws IOException {
        FileInputStream fis = new FileInputStream("src\\testNIO.txt");
        FileChannel fileChannel = fis.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        while (true) {
            //表示从通道中读取了多少字节的数据，如果没有数据可读返回-1 ；
            int n = fileChannel.read(byteBuffer);
            System.out.println("read..."+n);
            if (n == -1) {
                break;
            }
            //转换成读模式
            byteBuffer.flip();
            //从缓存中读取数据每次读取一个字节；
            while (byteBuffer.hasRemaining()) {
                System.out.println("read : " + byteBuffer.get());
            }
            //清空缓存中的内容以便于下次内容的在次写入
            byteBuffer.clear();
        }

 
        fis.close();
    }

private static void testCopyFile() throws IOException {
        FileInputStream fis = new FileInputStream("src\\testNIO.txt");
        FileOutputStream fos = new FileOutputStream("src\\testNIOCopy.txt");
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        // 此时position=0,limit=capacity
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        while (true) {
            int n = inChannel.read(byteBuffer);
            System.out.println("n = " + n);
            if (n == -1) {
                break;
            }
            //这是position=0;limit=3  开启写模式
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            //clear()后回归原始状态
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
