package 排序;

import java.util.Arrays;

public class 插入排序 {



    public static void main(String[] args) {
        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        ReducedIncrement(a);
        System.out.println(Arrays.toString(a));

    }


    /**
     * 插入循环
     * 一个static Loop includes a dynamic loop  实现了动态插入位置的过程；
     * @param a
     */
    static  void Insert_Sort(int[] a){

        for(int j=1;j<a.length;j++){

            int i=j;
            int temp=a[i];
            while(i-1>=0&&temp<a[i-1]){
                a[i]=a[i-1];
                i--;
            }
            a[i]=temp;
            System.out.println(Arrays.toString(a));
        }
    }


    /***
     * 希尔排序
     * 又称为缩小增量法
     */
   static void ReducedIncrement(int[] a){
        int len=a.length;

        for (int i=len/2;i>0;i=i/2){

            for (int j=i;j<len;j++){
                int x=a[j];
                while(j-i>=0&&a[j-i]>a[j]){
                    a[j]=a[j-i];
                    j=j-i;
                }
                a[j]=x;
            }
        }

    }


}
