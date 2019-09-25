package 总结一.动态规划.合并石子之动态规划__keneng;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	
	
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static int leng,x,n=20000,index=1,pri=0;
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		leng=scan.nextInt();
		for(int i=1;i<=leng;i++) {
			x=scan.nextInt();
			list.add(x);
	
		}
		for(int j=1;j<=leng-1;j++) {
			int y = 0;
			for(int i=0;i<list.size()-1;i++) {
				if((y=list.get(i)+list.get(i+1))<n){
					n=y;
					index=i;
					}			
					
				
			}
			
			pri+=n;
			list.set(index, n);
			list.remove(index+1);
			n=20000;
		}
		System.out.println(pri);
		
		
		
	}
	
	
	
	

}
