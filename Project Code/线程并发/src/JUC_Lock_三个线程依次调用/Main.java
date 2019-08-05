package JUC_Lock_三个线程依次调用;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

	public static void main(String[] args) {
		
		Alternate_printf loop=new Alternate_printf();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<9;i++) {
					loop.LoopA(i);
				}
				
				
			}
			
		},"A").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<9;i++) {
					loop.LoopB(i);
				}
				
				
			}
			
		},"B").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<9;i++) {
					loop.LoopC(i);
				}
				
				
			}
			
		},"C").start();
	}
	
	
}


class Alternate_printf{
	private int number =1;
	
	private Lock lock=new ReentrantLock();
	
	private Condition conditionA=lock.newCondition();
	private Condition conditionB=lock.newCondition();
	private Condition conditionC=lock.newCondition();
	
	
	
	public void LoopA(int loopnum) {
		
		lock.lock();
		try {
			if(number!=1) {
				conditionA.await();
			}
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+":"+loopnum);
			}
			number=2;
			conditionB.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
		
		
	}
	public void LoopB(int loopnum) {
		
		lock.lock();
		try {
			if(number!=2) {
				conditionB.await();
			}
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+":"+loopnum);
			}
			number=3;
			conditionC.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
		
		
	}
	public void LoopC(int loopnum) {
		
		lock.lock();
		try {
			if(number!=3) {
				conditionC.await();
			}
			for(int i=0;i<5;i++) {
				System.out.println(Thread.currentThread().getName()+":"+loopnum);
			}
			number=1;
			conditionA.signal();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
		
		
		
		
	}
	
}















