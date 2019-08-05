package 排序;

import java.util.Arrays;

public class 归并排序 {


    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        merge_sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 归并排序
     * 1.分割： 这个递归分割就好了；
     * 2.合并： 合并数据是一个 dynamic 判定的过程；
     * dynamic loop  ：
     * 在不违背前提条件的情况下，判定是谁需要做相应的处理；
     *
     * @param a
     * @param s : 起点
     * @param e ：终点
     */
    private static void merge_sort(int[] a,int s,int e) {

        //首先不断分割；
        if(s<e){
            //分割：
            int div =(s+e)/2;
            merge_sort(a,s,div);
            merge_sort(a,div+1,e);
            //合并
            merge(a,s,div,div+1,e);
        }
    }

    private static void merge(int[] a, int i1, int i2, int j1, int j2) {
        int[] buffer=new int[j2-i1+1];
        int x=0;int s=i1,e=j2;
        //dynamic merge sort
        while (i1<=i2&&j1<=j2){
            if(a[i1]<a[j1])
                buffer[x++]=a[i1++];
            else
                buffer[x++]=a[j1++];
        }
        while (i1<=i2){
            buffer[x++]=a[i1++];
        }
        while (j1<=j2){
            buffer[x++]=a[j1++];
        }

        //take buffer data into Arrays;
        int y=0;
        for(int i=s;i<=e;i++){
            a[i]=buffer[y++];
        }


    }


}
