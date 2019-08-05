package 异步非阻塞__AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * AIO 异步非阻塞
 * @aurthor chenl on 2018/12/15
 */
public class AioServer {
	
    private static final Integer DEFAULT_PORT = 9998;
    /**
     *  线程池提高服务端效率
     */
   // private ExecutorService service;
    /**
     *  服务端通道，针对服务端定义的端口号
     */
    private AsynchronousServerSocketChannel serverChannel;

    public AioServer(int port) {
        init(port);
    }
    
    private void init(int port) {
        System.out.println("server starting at port : " + port + "....");
        InetSocketAddress ip = new InetSocketAddress(port);
        //1.创建一个只有核心线程的线程池；
     /*   service=new ThreadPoolExecutor(4, 4, 0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),
        		new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                });
    */
        
        try {
            // 2.创建一个异步服务端通道，并且绑定监听端口
            serverChannel = AsynchronousServerSocketChannel.open();
            serverChannel.bind(ip);
            System.out.println("server started...");
            // 阻塞监听
            // accept(T attachment, CompletionHandler<AsynchronousSocketChannel,? super T> handler);
            serverChannel.accept(this, new AioSeverHandle());
            System.out.println("释放serverChannel.accept(this, new AioSeverHandle())0;");
            TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        AioServer server = new AioServer(DEFAULT_PORT);
    }

  /*  public ExecutorService getService() {
        return service;
    }

    public void setService(ExecutorService service) {
        this.service = service;
    }*/

    public AsynchronousServerSocketChannel getServerChannel() {
        return serverChannel;
    }

    public void setServerChannel(AsynchronousServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }
}

