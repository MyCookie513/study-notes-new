package �첽������__AIO;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Scanner;

/**
 * AIO �첽������
 * ����BIO��AIO��NIO�У�һ�����������ˣ����˶���ƽ�ȵ�
 * @aurthor chenl on 2018/12/15
 */
public class AioSeverHandle implements CompletionHandler<AsynchronousSocketChannel, AioServer> {

    /**
     * ҵ�����߼������������󣬼����ɹ���Ӧ����ʲô����
     * һ��Ҫʵ�ֵ��߼���Ϊ��һ�οͻ�������������������accept()
     * @param result ���ǺͿͻ���ֱ�ӽ���������ͨ������ͨ���е�������ݡ������ϵͳ׼���õĶ�ȡ���ݻ��棬��ȴ��������ݵĻ���
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel result, AioServer attachment) {
    //	System.out.println("����һ�������������Ϣ��������һ�οͻ����������Ƶݹ��߼�");
        // ������һ�οͻ����������Ƶݹ��߼�
        attachment.getServerChannel().accept(attachment, this);
        doRead(result);
    }

    private void doRead(final AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * �첽������
         *  read(
         *          ByteBuffer destination, Ŀ�ĵأ��Ǵ���ͻ��˴������ݵ���ת���棬�ɲ���
                    T attachment,  ����ͻ��˴������ݵĶ���ͨ����Buffer����
                    CompletionHandler<Integer,? super T> handler)) �����߼�
         *
         */
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            /**
             * ҵ���߼�����ȡ�ͻ��˴�������
             * @param result
             * @param attachment ��completed����ִ��ʱ������ϵͳ�Ѿ����ͻ������������д�뵽Buffer�������ˣ���Ϊ��λflip()��ʹ��ǰһ��Ҫ��λ
             */
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println(attachment.capacity());
                // ��λ
                attachment.flip();
                try {
                    System.out.println("from client : " + new String(attachment.array(), "UTF-8"));
                    System.out.println("�յ�һ����Ϣ֮��ظ��ͻ���һ����Ϣ");
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
     *  ��ʵ��Ŀ�У����������صĽ��Ӧ���Ǹ��ݿͻ��˵��������õ��ġ�
     * @param channel
     */
    private void doWriter(AsynchronousSocketChannel channel) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("enter message send to client > ");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        try {
            buffer.put(line.getBytes("UTF-8"));
            // ���븴λ
            buffer.flip();
            // writer()�������첽����������ʵ���ɲ���ϵͳʵ�֡�������get()������ʵ���������ȴ�����ϵͳ��д��������
            channel.write(buffer);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * �쳣�����߼���������˴�������쳣��ʱ��Ӧ����ʲô����
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, AioServer attachment) {
        exc.printStackTrace();
    }
}
