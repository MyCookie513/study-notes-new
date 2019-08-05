package testforkjoinpool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

	public static void main(String[] args) {
		
		
		//新建一个分支合并框架的线程池；
		ForkJoinPool pool=new ForkJoinPool();
		
		//新建一个分支合并类型的递归任务（可带返回值也可不带）
		fork_join_sum_calculate task=new fork_join_sum_calculate(0L,10000000000L);
		Instant start=Instant.now();
		//在分支合并任务线程池中放入这个大型任务，会自动进行拆分，压入任务队列然后线程尽可能的去调用处理这些任务
		long sum=pool.invoke(task);
		System.out.println(sum);
		Instant end=Instant.now();
		System.out.println(Duration.between(start, end).toMillis());
	}
	
}


//1.new一个类继承一个具有返回值的递归任务的父类；
class fork_join_sum_calculate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long start;
	private long end;
	private static final long THURSHOLD =10000L;
	
	
	
	fork_join_sum_calculate(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}



	@Override
	protected Long compute() {
		long length=end-start;
		if(length<=THURSHOLD) {
			long sum=0L;
			for(long i=start;i<=end;i++) {
				sum+=i;
			}
			return sum;
		}else {
			long middle=(start+end)/2;
			fork_join_sum_calculate left=new fork_join_sum_calculate(start,middle);
			left.fork();//进行拆分同时压入线程队列；
			fork_join_sum_calculate right=new fork_join_sum_calculate(middle+1,end);
			right.fork();
			return left.join()+right.join();
		}
		
		
	}
	
}

