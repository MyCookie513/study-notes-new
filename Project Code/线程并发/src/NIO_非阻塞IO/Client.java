package NIO_非阻塞IO;







public class Client {
	private static String DEFAULT_HOST = "127.0.0.1";
	private static int DEFAULT_PORT = 8085;
	private static ClientHandle clientHandle;
	public static void start(){
		start(DEFAULT_HOST,DEFAULT_PORT);
	}
	public static synchronized void start(String ip,int port){
		if(clientHandle!=null)
			clientHandle.stop();
		clientHandle = new ClientHandle(ip,port);
		new Thread(clientHandle,"Server").start();
	}
	//向服务器发送消息
	public static boolean sendMsg(String msg) throws Exception{
		System.out.println("已经调用了发送消息函数进行了socketchannel的read事件的注册；");
		if(msg.equals("q")) return false;
		clientHandle.sendMsg(msg);
		return true;
	}
	public static void main(String[] args){
		start();
	}
}

