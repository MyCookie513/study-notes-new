package 高并发第一阶段.JUC_Lock锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	public static void main(String[] args) {
		Ticket ti=new Ticket();
		int i=3;
		while(i>0) {
			new Thread(ti).start();
			i--;
		}
		

	}
	
	

}
class Ticket implements Runnable{
	private int ticket=20;

	Lock lock=new ReentrantLock();
	@Override
	public void run() {
	
		lock.lock();
		try {
			while(ticket>0) {
				System.out.println(Thread.currentThread().getName()+"完成售票"+(--ticket));
			}
			
		}finally {
			lock.unlock();
		}
		
	}

}
