package JUC_LockËø;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	public static void main(String[] args) {
		/*Ticket ti=new Ticket();
		int i=3;
		while(i>0) {
			new Thread(ti).start();
			i--;
		}*/
		
		Integer a=1;
		Integer b=1;
		Integer a0=500;
		Integer b0=500;
		System.out.println(a==b);
		System.out.println(a0==b0);
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
				System.out.println(Thread.currentThread().getName()+"Íê³ÉÊÛÆ±"+(--ticket));
			}
			
		}finally {
			lock.unlock();
		}
		
	}
	
	
	
	
	
}
