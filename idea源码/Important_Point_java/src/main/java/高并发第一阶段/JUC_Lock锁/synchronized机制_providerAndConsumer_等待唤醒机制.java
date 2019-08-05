package 高并发第一阶段.JUC_Lock锁;

public class synchronized机制_providerAndConsumer_等待唤醒机制 {



	public static void main(String[] args) {


		Mark mark=new Mark();
		product pro =new product(mark);
		Consumer con =new Consumer(mark);

		new Thread(pro,"生产者A").start();
		new Thread(con,"消费者B").start();
		new Thread(pro,"生产者C").start();
		new Thread(con,"消费者D").start();
	}


}

class Mark {

	private int product = 0;

	// 进货
	public synchronized void get() {
		while(product >= 1) {

			System.out.println(Thread.currentThread().getName() + ": 库存已满 ，线程停止生产");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + ": 进货成功：" + (++product));

		//生产出货来通知消费者去使用；
		this.notifyAll();

	}

	// 出货
	public synchronized void sale() {
		while(product <= 0) {

			//如果产品消费空了；消费线程停止；
			System.out.println(Thread.currentThread().getName() + ": 库存已无货,线程等待；");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println(Thread.currentThread().getName() + ": 出货成功：" + (--product));
		//消费之后，通知生产者继续生产；
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
