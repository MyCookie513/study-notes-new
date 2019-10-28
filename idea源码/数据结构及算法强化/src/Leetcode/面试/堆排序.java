package Leetcode.面试;

import java.util.Arrays;

public class 堆排序 {

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        heap_sort(a);
        System.out.println(Arrays.toString(a));
    }


    public static  void heap_sort(int[] a ){
        if (a==null )
            return;

        int x=a.length/2-1;
        for (int i = x; i >=0; i--) {
            adust_heap(a,i,a.length-1);
        }
        int[] b=new int[a.length];
        int t;
        for (int i = 0; i <a.length ; i++) {
            t=a.length-i-1;
            b[i]=a[0];
            a[0]=a[t];
            adust_heap(a,0,t-1);
        }

        for (int i = 0; i <a.length ; i++) {
            a[i]=b[i];
        }


    }

    private static void adust_heap(int[] a, int i, int length) {
        int x;
        while (true){
            x=2*i+1;
            if (x>length)
                break;
            if (x+1<=length && a[x+1]<a[x]){
                x++;
            }
            if (a[i]>a[x]){
                int z=a[i];
                a[i]=a[x];
                a[x]=z;
                i=x;
            }else{
                break;
            }
        }


    }


}
