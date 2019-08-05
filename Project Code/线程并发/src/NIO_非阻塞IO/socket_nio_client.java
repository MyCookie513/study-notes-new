package NIO_非阻塞IO;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
 
public class socket_nio_client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8085));
 
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
 
        while (true) {
            int n = selector.select();
            if (0 == n) {
                continue;
            }
 
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
 
                // 连接服务端
                if (selectionKey.isConnectable()) {
                    System.out.println("client connect...");
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
 
                    // 如果正在连接，则完成连接
                    if (socketChannel1.isConnectionPending()) {
                        socketChannel1.finishConnect();
                    }else {
                    	System.out.println("客户端连接失败");
                    }
                    socketChannel1.configureBlocking(false);
                    // 发送数据到服务端
                    ByteBuffer byteBuffer = ByteBuffer.wrap("I'm Client. I send u".getBytes());
                    socketChannel1.write(byteBuffer);
 
                    // 接下来是监听服务端的回应了
                    socketChannel1.register(selector, SelectionKey.OP_READ);
 
                }
 
                // 接受服务器的回应
                else if (selectionKey.isReadable()) {
                    System.out.println("client reading...");
                    SocketChannel socketChannel1 = (SocketChannel) selectionKey.channel();
                    socketChannel1.configureBlocking(false);
 
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
 
                    while (true) {
                        int s = socketChannel1.read(byteBuffer);
                        System.out.println("s="+s);
                        if (s == 0 || s == -1) {
                            break;
                        }
                        byteBuffer.flip();
                        while (byteBuffer.hasRemaining()) {
                            System.out.print((char) byteBuffer.get());
                        }
                        System.out.println("\n******");
                        byteBuffer.clear();
                    }
                    socketChannel1.close();
                }
                iterator.remove();
            }
        }
    }
}
