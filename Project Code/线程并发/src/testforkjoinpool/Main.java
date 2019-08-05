package testforkjoinpool;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Main {

	public static void main(String[] args) {
		
		
		//�½�һ����֧�ϲ���ܵ��̳߳أ�
		ForkJoinPool pool=new ForkJoinPool();
		
		//�½�һ����֧�ϲ����͵ĵݹ����񣨿ɴ�����ֵҲ�ɲ�����
		fork_join_sum_calculate task=new fork_join_sum_calculate(0L,10000000000L);
		Instant start=Instant.now();
		//�ڷ�֧�ϲ������̳߳��з�������������񣬻��Զ����в�֣�ѹ���������Ȼ���߳̾����ܵ�ȥ���ô�����Щ����
		long sum=pool.invoke(task);
		System.out.println(sum);
		Instant end=Instant.now();
		System.out.println(Duration.between(start, end).toMillis());
	}
	
}


//1.newһ����̳�һ�����з���ֵ�ĵݹ�����ĸ��ࣻ
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
			left.fork();//���в��ͬʱѹ���̶߳��У�
			fork_join_sum_calculate right=new fork_join_sum_calculate(middle+1,end);
			right.fork();
			return left.join()+right.join();
		}
		
		
	}
	
}

