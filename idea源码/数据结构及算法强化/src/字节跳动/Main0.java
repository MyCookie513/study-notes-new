package 字节跳动;

import java.util.Scanner;

public class Main0 {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );
        int n =sc.nextInt();

        int[] a=new int[n];
        int[] JS =new int[n];


        a[0]=sc.nextInt();
        for (int i =1;i<n;i++){
            a[i]=sc.nextInt();
            int x=i-1;
            while (x>=0){
                if (a[x]>=a[i]){
                    break;
                }
                x--;
            }
            if (x!=-1){
                JS[x]++;
            }
        }

        int zuobiao =0;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            if (JS[i]>max){
                max=JS[i];
                zuobiao=i;
            }
        }
        System.out.println(a[zuobiao]);



    }



}
