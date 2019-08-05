package JUC_Lock锁;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock机制_ProviderAndConsumer__唤醒等待机制 {

	
	
	public static void main(String[] args) {
		
		
		Mark0 mark=new Mark0();
		product0 pro =new product0(mark);
		Consumer0 con =new Consumer0(mark);

		new Thread(pro,"生产者A").start();
		new Thread(con,"消费者B").start();
		new Thread(pro,"生产者C").start();
		new Thread(con,"消费者D").start();
	}
	
	
}

class Mark0 {

	private int product = 0;
	private Lock lock=new ReentrantLock();

	private Condition condtion=lock.newCondition();
	// 进货
	public  void get() {
		lock.lock();
		try {
			while(product >= 1) {

				System.out.println(Thread.currentThread().getName() + ": 库存已满 ，线程停止生产");
				try {
					condtion.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
				System.out.println(Thread.currentThread().getName() + ": 进货成功：" + (++product));

				//生产出货来通知消费者去使用；
				condtion.signalAll();
		}finally {
			lock.unlock();
		}
		
		
	}

	// 出货
	public  void sale() {
		lock.lock();
		try {
			while(product <= 0) {

				//如果产品消费空了；消费线程停止；
				System.out.println(Thread.currentThread().getName() + ": 库存已无货,线程等待；");
			    try {
					condtion.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
				
				System.out.println(Thread.currentThread().getName() + ": 出货成功：" + (--product));
	            //消费之后，通知生产者继续生产；
				condtion.signalAll();
		}finally {
			lock.unlock();
		}
		
		
	}

}

// Productor

class product0 implements Runnable {

	private Mark0 mark;

	product0(Mark0 mark) {
		super();
		this.mark = mark;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			
			mark.get();
		//	System.out.println(i);

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}

}

class Consumer0 implements Runnable {

	private Mark0 mark;

	Consumer0(Mark0 mark) {
		super();
		this.mark = mark;
	}

	@Override
	public void run() {

		for (int i = 0; i < 20; i++) {
			mark.sale();
		}

	}

}
