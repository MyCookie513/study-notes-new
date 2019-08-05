package NIO.CilentAndServer.Client;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO�ͻ���
 *
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class ClientHandler implements Runnable {
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean started;

    public ClientHandler(String ip, int port) {
        this.host = ip;
        this.port = port;
        try {
            //创建选择器
            selector = Selector.open();
            //打开监听通道
            socketChannel = SocketChannel.open();
            //如果为 true，则此通道将被置于阻塞模式；如果为 false，则此通道将被置于非阻塞模式
            socketChannel.configureBlocking(false);//开启非阻塞模式
            started = true;

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        started = false;
    }
    //将一个非阻塞模式的 SocketChannel 连接到服务器的一个端口，并且注册连接事件到多路复用器上
    private void doConnect() throws IOException{
        socketChannel.connect(new InetSocketAddress(host,port));
        //将socketChannel注册到selector多路复用器；注册事件为连接事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }
    public void run() {
        try{
            doConnect();
            System.out.println("进行尝试连接状态；");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("尝试连接到服务器失败；");
            System.exit(1);

        }
        //循环遍历selector
        while(started){
            try{
                //无论是否有读写事件发生，selector每隔1s被唤醒一次
                selector.select(1000);
                //阻塞,只有当至少一个注册的事件发生的时候才会继续.
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> it = keys.iterator();
                SelectionKey key = null;
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    try{
                        handleInput(key);
                        boolean b=false;
                    }catch(Exception e){
                        if(key != null){
                            key.cancel();
                            if(key.channel() != null){
                                key.channel().close();
                            }
                        }
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
                System.exit(1);
            }
        }
        //selector关闭后会自动释放里面管理的资源
        if(selector != null)
            try{
                selector.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        if(socketChannel!=null) {
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleInput(SelectionKey key) throws IOException{
        if(key.isValid()){
            SocketChannel sc = (SocketChannel) key.channel();
            //判定连接是否是在连接过程中
            if(key.isConnectable()) {
                System.out.println("client connect...");
                // 如果是连接待定状态，则完成连接
                if (sc.isConnectionPending()) {
                    sc.finishConnect();
                } else {
                    System.out.println("客户端连接失败");
                }
                //设置通道为非阻塞模式
                sc.configureBlocking(false);
                // 发送数据到服务端
                ByteBuffer byteBuffer = ByteBuffer.wrap("I'm Client. I send u".getBytes());
                sc.write(byteBuffer);

                // 接下来是监听服务端的回应了
                sc.register(selector, SelectionKey.OP_READ);
            }
//****************************************************消息处理部分************************************************************
            if(key.isReadable()){
                //创建ByteBuffer，并开辟一个1M的缓冲区
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                //读取请求码流，返回读取到的字节数
                int readBytes = sc.read(buffer);
                //读取到字节，对字节进行编解码
                if(readBytes>0){
                    //将缓冲区当前的limit设置为position=0，用于后续对缓冲区的读取操作
                    buffer.flip();
                    //根据缓冲区可读字节数创建字节数组
                    byte[] bytes = new byte[buffer.remaining()];
                    //将缓冲区可读字节数组复制到新建的数组中
                    buffer.get(bytes);
                    String result = new String(bytes,"UTF-8");
                    System.out.println("客户端收到消息：" + result);

                } else if(readBytes<0){
                    key.cancel();
                    sc.close();
                }
            }
 //***********************************************************************************************************************

        }
    }
    //异步发送消息
    private void doWrite(SocketChannel channel,String request) throws IOException{
        //将消息编码为字节数组
        byte[] bytes = request.getBytes();
        //根据数组容量创建ByteBuffer
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        //将字节数组复制到缓冲区
        writeBuffer.put(bytes);
        //flip操作
        writeBuffer.flip();
        //发送缓冲区的字节数组
        channel.write(writeBuffer);
        //****此处不含处理“写半包”的代码
    }


    public void sendMsg(String msg) throws Exception{
        socketChannel.register(selector, SelectionKey.OP_READ);
        doWrite(socketChannel, msg);
    }

}
