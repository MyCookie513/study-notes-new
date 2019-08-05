package 高并发第二阶段.GuardedSuspension;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue=new RequestQueue();
        ServerThread serverThread=new ServerThread(queue );
        ClientThread clientThread=new ClientThread(queue,"message", serverThread);
        clientThread.start();
        serverThread.start();

    }
}
