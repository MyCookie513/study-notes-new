package 异步非阻塞__AIO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * AIO 异步非阻塞
 * @aurthor chenl on 2018/12/15
 */
public class AioClient {
    private AsynchronousSocketChannel channel;

    public static void main(String[] args) {
        AioClient client = new AioClient("localhost", 9998);
        try {
            System.out.println("enter message send to server > ");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            client.write(line);
            client.read();
        } finally {
            client.destory();
        }
    }

    public AioClient(String host, int port) {
        init(host, port);
    }

    private void init(String host, int port) {
        InetSocketAddress ip = new InetSocketAddress(host, port);
        try {
            // 开启客户端通道
            channel = AsynchronousSocketChannel.open();
            // 发起请求，建立连接
            channel.connect(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String line) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            buffer.put(line.getBytes("UTF-8"));
            buffer.flip();
            channel.write(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void read() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // read方法是异步方法，由操作系统实现
        Future<Integer> future = channel.read(buffer);
        try {
            // get方法是阻塞方法，会等待操作系统处理结束再返回
            future.get();
            buffer.flip();
            System.out.println("from server : " + new String(buffer.array(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void destory() {
        if (channel != null) {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        channel = null;
    }
}

