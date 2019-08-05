package 排序;

import java.util.Arrays;

public class 冒泡排序优化版 {

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        maopao(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 冒泡排序的优化
     * 1.保存后边部分或者前面部分原本已经排好序的情况
     * @param a
     */
    private static void maopao(int[] a) {

        int x=0;
        for (int i=a.length-1;i>0;){
            for (int j=0;j<i;j++){
                System.out.println("j: "+j);
                if (a[j]>a[j+1]){
                    swap(a,j,j+1);
                    x=j;
                }
            }
            i=x;
            x=0;
        }


    }

    private static void swap(int[] a, int j, int i) {
        int x=a[j];
        a[j]=a[i];
        a[i]=x;
    }

}
