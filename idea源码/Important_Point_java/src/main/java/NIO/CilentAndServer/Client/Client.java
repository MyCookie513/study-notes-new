package NIO.CilentAndServer.Client;


import java.util.Scanner;

public class Client {
	private static String DEFAULT_HOST = "127.0.0.1";
	private static int DEFAULT_PORT = 8085;
	private static ClientHandler clientHandler;


	public static void main(String[] args) throws  Exception{
		start();
		Scanner scanner=new Scanner(System.in);
		while (true){
			String x=scanner.next();
			if(x.equals("exit")){
				clientHandler.stop();
				break;
			}

			else if(x.equals("msg")){
				String msg=scanner.next();
				if(sendMsg(msg))
					System.out.println("消息发送成功");
			}

		}

	}


	public static void start(){
		start(DEFAULT_HOST,DEFAULT_PORT);
	}

	/**
	 *
	 * @param ip
	 * @param port
	 */
	public static synchronized void start(String ip,int port){
		if(clientHandler!=null)
			clientHandler.stop();
		clientHandler = new ClientHandler(ip,port);
		new Thread(clientHandler,"Client").start();
	}

	public static boolean sendMsg(String msg) throws Exception{
		clientHandler.sendMsg(msg);
		return true;
	}

}

