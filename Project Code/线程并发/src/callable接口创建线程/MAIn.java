package callable接口创建线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MAIn {

	
	public static void main(String[] args) {
		Lock lock=new ReentrantLock();
		//需要借助FutureTask类来获取结果；
		threaddemo thread=new threaddemo();
		FutureTask<Integer> result=new FutureTask<>(thread);
		
		new Thread(result).start();
		System.out.println(99999);
		try {
		
			//get()会有阻塞线程的功能；相当于闭锁之后才能进行；
			System.out.println(	result.get());
			System.out.println(6666);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
class threaddemo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<3000;i++) {
		sum+=i;
		
		}
		
		System.out.println(sum);
		return sum;
	}
	
}