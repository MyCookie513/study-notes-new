package 排序;

import 线段树.Query_Range_Update_Range;

import java.util.Arrays;

public class 快速排序 {


    public static void main(String[] args) {
        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        Quick_Sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));

    }


    /**
     *整体： 总Dynamic循环里面嵌套两个小Dynamic循环
     * @param a
     * @param L
     * @param R
     */
    private static void Quick_Sort(int[] a,int L,int R){

        if(L<R) {

            int l=L,r=R;

            int x = a[R];

            while (L != R) {
                while (L < R && a[L] <= x) {
                    L++;
                }
                if (a[L] > x)
                    change(a, L, R);
                while (L < R && a[R] >= x) {
                    R--;
                }

                if (a[R] < x)
                    change(a, L, R);
            }

            Quick_Sort(a,l,L-1);

            Quick_Sort(a,L+1,r);

        }
    }

    private static  void change(int[] a, int l, int r) {
        int x=a[l];
        a[l]=a[r];
        a[r]=x;
    }


}
