package 排序;

import java.util.Arrays;

public class 冒泡排序 {

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        maopao(a);
        System.out.println(Arrays.toString(a));
    }

    private static void maopao(int[] a) {

        for (int i=a.length-1;i>0;i--){
            for (int j=0;j<i;j++){
                if (a[j]>a[j+1])
                    swap(a,j,j+1);
            }
        }


    }

    private static void swap(int[] a, int j, int i) {
        int x=a[j];
        a[j]=a[i];
        a[i]=x;
    }

}
