package JUC_Lock��;

public class synchronized����_providerAndConsumer_�ȴ����ѻ��� {

	
	
	public static void main(String[] args) {
		
		
		Mark mark=new Mark();
		product pro =new product(mark);
		Consumer con =new Consumer(mark);

		new Thread(pro,"������A").start();
		new Thread(con,"������B").start();
		new Thread(pro,"������C").start();
		new Thread(con,"������D").start();
	}
	
	
}

class Mark {

	private int product = 0;

	// ����
	public synchronized void get() {
		while(product >= 1) {

			System.out.println(Thread.currentThread().getName() + ": ������� ���߳�ֹͣ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
			System.out.println(Thread.currentThread().getName() + ": �����ɹ���" + (++product));

			//����������֪ͨ������ȥʹ�ã�
			this.notifyAll();
		
	}

	// ����
	public synchronized void sale() {
		while(product <= 0) {

			//�����Ʒ���ѿ��ˣ������߳�ֹͣ��
			System.out.println(Thread.currentThread().getName() + ": ������޻�,�̵߳ȴ���");
		    try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
			
			System.out.println(Thread.currentThread().getName() + ": �����ɹ���" + (--product));
            //����֮��֪ͨ�����߼���������
			this.notifyAll();
		
	}

}

// Productor

class product implements Runnable {

	private Mark mark;

	product(Mark mark) {
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

class Consumer implements Runnable {

	private Mark mark;

	Consumer(Mark mark) {
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
