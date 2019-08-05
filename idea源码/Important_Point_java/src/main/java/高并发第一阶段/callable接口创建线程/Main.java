package 高并发第一阶段.callable接口创建线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {


	public static void main(String[] args) {

		Thread_Callable callable=new Thread_Callable();
		//需要借助FutureTask类来获取结果；
		FutureTask<Integer> result=new FutureTask<>(callable);
		new Thread(result).start();

		System.out.println("线程已经开启运行");
		try {

			//get()会有阻塞线程的功能；相当于闭锁之后才能进行；
			System.out.println("线程最终得到的结果为："+result.get());

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (ExecutionException e) {

			e.printStackTrace();
		}

	}




}
class Thread_Callable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=0;i<3000;i++) {
			sum+=i;

		}
       Thread.currentThread().sleep(3000);
		System.out.println(sum);
		return sum;
	}

}