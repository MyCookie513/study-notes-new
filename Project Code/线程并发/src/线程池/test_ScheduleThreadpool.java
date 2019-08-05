package 线程池;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class test_ScheduleThreadpool {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Xuexue xuexue=new Xuexue();
		ScheduledExecutorService ScheduledPool=Executors.newScheduledThreadPool(5);
		//调度进行设置每三秒执行一次；
		for(int i=0;i<5;i++) {
			Future<Integer> result=ScheduledPool.schedule(xuexue,3,TimeUnit.SECONDS);
			
			System.out.println(result.get());
			
		}
		ScheduledPool.shutdown();
		
	}
}
class Xuexue implements Callable<Integer>{
	private int sum=0;

	@Override
	public Integer call() throws Exception {
		sum+=new Random().nextInt(10);
		System.out.println(Thread.currentThread().getName()+":"+sum);
		return sum ;
	}
	
}