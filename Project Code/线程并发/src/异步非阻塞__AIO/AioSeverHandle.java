package 异步非阻塞__AIO;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;

/**
 * AIO 异步非阻塞
 * 无论BIO、AIO、NIO中，一旦建立连接了，两端都是平等的
 * @aurthor chenl on 2018/12/15
 */
public class AioSeverHandle implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    /**
     * 业务处理逻辑，当请求到来后，监听成功，应该做什么事情
     * 一定要实现的逻辑：为下一次客户端请求开启监听，调用accept()
     * @param result 就是和客户端直接建立关联的通道，有通道中的相关数据。如操作系统准备好的读取数据缓存，或等待返回数据的缓存
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
    //	System.out.println("来了一次连接请求或消息，处理下一次客户端请求，类似递归逻辑");
        // 处理下一次客户端请求，类似递归逻辑
        attachment.getServerChannel().accept(attachment, this);
        doRead(result);
    }

    private void doRead(final AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * 异步读操作
         *  read(
         *          ByteBuffer destination, 目的地，是处理客户端传递数据的中转缓存，可不用
                    T attachment,  处理客户端传递数据的对象，通常用Buffer处理
                    CompletionHandler<Integer,? super T> handler)) 处理逻辑
         *
         */
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            /**
             * 业务逻辑，读取客户端传输数据
             * @param result
             * @param attachment 在completed方法执行时，操作系统已经将客户端请求的数据写入到Buffer缓存中了，但为复位flip()，使用前一定要复位
             */
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(attachment.capacity());
                // 复位
                attachment.flip();
                try {
                    System.out.println("from client : " + new String(attachment.array(), "UTF-8"));
                    System.out.println("收到一个消息之后回复客户端一个消息");
                    doWriter(channel);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }

    /**
     *  真实项目中，服务器返回的结果应该是根据客户端的请求计算得到的。
     * @param channel
     */
    private void doWriter(AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("enter message send to client > ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        try {
            buffer.put(line.getBytes("UTF-8"));
            // 必须复位
            buffer.flip();
            // writer()方法是异步操作，具体实现由操作系统实现。可增加get()方法，实现阻塞，等待操作系统的写操作结束
            channel.write(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常处理逻辑，当服务端代码出现异常的时候，应该做什么事情
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.printStackTrace();
    }
}
