package Readwritelock_¶ÁÐ´Ëø;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		ReadwriteDemo test=new ReadwriteDemo();
		
		for(int i=9;i<10000;i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					test.get();
					
				}
				
			},"read").start();
		}
		
		new Thread(new Runnable() {

			@Override
			public void run() {

				test.Set(new Random().nextInt(100));
				
			}
			
		},"write").start();
	}
	
	
	
}


class ReadwriteDemo{
	

	private ReadWriteLock lock=new ReentrantReadWriteLock();
	private int number ;
	void  get() {
		lock.readLock().lock();;
		try {
			System.out.println(Thread.currentThread().getName()+number);
		}finally {
			lock.readLock().unlock();
		}
		
	}
	void  Set(int number) {
		lock.writeLock().lock();;
		try {
			this.number=number ;
			System.out.println(Thread.currentThread().getName()+this.number);

		}finally {
			lock.writeLock().unlock();
		}
		
	}
	
	
}