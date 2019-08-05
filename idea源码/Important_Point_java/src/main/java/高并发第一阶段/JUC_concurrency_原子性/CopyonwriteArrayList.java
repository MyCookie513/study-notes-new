package 高并发第一阶段.JUC_concurrency_原子性;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;



public class CopyonwriteArrayList {
	

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
	
		list.add("111");
		list.add("111");
		Iterator<String > it=list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			list.add("000");
		}
		Iterator<String > it0=list.iterator();
		
		while(it0.hasNext()) {
			System.out.println(it0.next());
			
		}
	}
}
