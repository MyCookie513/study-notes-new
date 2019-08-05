package countdownlatch_����;

import java.util.concurrent.CountDownLatch;

public class Main {

	
	
public static void main(String[] args) {
	
	//����һ���������ı�����
	CountDownLatch latch=new CountDownLatch(10);
	
	CountDownDemo count=new CountDownDemo(latch);
	
	long start=System.currentTimeMillis();
	long end;
	for(int i=0;i<10;i++) {
		new Thread(count).start();
	}
	try {
		latch.await();
	} catch (InterruptedException e) {
		
	
	}
	end=System.currentTimeMillis();
	System.out.println("���ĵ�ʱ��Ϊ:"+(-start+end));
	
	
	
}	
	

}
class CountDownDemo implements Runnable{

  public  CountDownLatch latch;
	@Override
	public void run() {
		
		synchronized(this){
			try {
				for(int i=0;i<300;i++) {
					System.out.println(i);
				}
			}finally {
				latch.countDown();
			}
			
		}
		
		
		
	}
	CountDownDemo(CountDownLatch latch) {
		super();
		this.latch = latch;
	}
	
	
	
	
	
	
}

