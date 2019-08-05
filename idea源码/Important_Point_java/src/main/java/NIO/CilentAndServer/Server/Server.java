package NIO.CilentAndServer.Server;


import java.util.Scanner;

public class Server {
	private static int DEFAULT_PORT = 8085;
	private static ServerHandler serverHandle;
	public static void start(){
		start(DEFAULT_PORT);
	}
	public static synchronized void start(int port){
		if(serverHandle!=null)
			serverHandle.stop();
		serverHandle = new ServerHandler(port);
		new Thread(serverHandle,"Server").start();
	}
	
	
	
	
	public static void main(String[] args){
		start();
		Scanner scanner=new Scanner(System.in);
		while (true){
			String x=scanner.next();
			System.out.println(x);
			if(x.equals("exit")){
				serverHandle.stop();
				break;
			}

		}
	}

	
}