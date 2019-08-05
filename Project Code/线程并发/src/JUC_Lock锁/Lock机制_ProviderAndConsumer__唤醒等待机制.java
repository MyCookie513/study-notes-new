package JUC_Lock��;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock����_ProviderAndConsumer__���ѵȴ����� {

	
	
	public static void main(String[] args) {
		
		
		Mark0 mark=new Mark0();
		product0 pro =new product0(mark);
		Consumer0 con =new Consumer0(mark);

		new Thread(pro,"������A").start();
		new Thread(con,"������B").start();
		new Thread(pro,"������C").start();
		new Thread(con,"������D").start();
	}
	
	
}

class Mark0 {

	private int product = 0;
	private Lock lock=new ReentrantLock();

	private Condition condtion=lock.newCondition();
	// ����
	public  void get() {
		lock.lock();
		try {
			while(product >= 1) {

				System.out.println(Thread.currentThread().getName() + ": ������� ���߳�ֹͣ����");
				try {
					condtion.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
				System.out.println(Thread.currentThread().getName() + ": �����ɹ���" + (++product));

				//����������֪ͨ������ȥʹ�ã�
				condtion.signalAll();
		}finally {
			lock.unlock();
		}
		
		
	}

	// ����
	public  void sale() {
		lock.lock();
		try {
			while(product <= 0) {

				//�����Ʒ���ѿ��ˣ������߳�ֹͣ��
				System.out.println(Thread.currentThread().getName() + ": ������޻�,�̵߳ȴ���");
			    try {
					condtion.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
				
				System.out.println(Thread.currentThread().getName() + ": �����ɹ���" + (--product));
	            //����֮��֪ͨ�����߼���������
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
