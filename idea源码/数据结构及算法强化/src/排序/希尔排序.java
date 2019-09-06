package 排序;

import java.util.Arrays;

public class 希尔排序 {

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        xier(a);
        System.out.println(Arrays.toString(a));
    }

    private static void xier(int[] a) {

        int x=a.length;

        //增量的设定；
        for (;x>0;x=x/2){
            //插入排序
            for (int i=x;i<a.length;i++){
                //每一个点都向右移动
                int i0=i;
                while (i0-x>=0 && a[i0]<a[i0-x]){
                    change(a,i0,i0-x);
                }
            }
        }


    }

    private static void change(int[] a, int i0, int i) {
        int x=a[i0];
        a[i0]=a[i];
        a[i]=x;
    }
}
