package 排序.练习;

import java.util.Arrays;

public class 堆排序 {

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        heap_sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * todo 完全二叉树的最后一个非叶子节点的index :  (a.length-1)/2
     * @param a
     */
    private static void heap_sort(int[] a) {
        int last = (a.length-1)/2;


        for (int i = last; i >=0;  i--) {
            adjust(a,i,a.length-1);
        }


        int[] b=new int[a.length];

        for (int i = 0; i <a.length-1; i++) {
            int x=a.length-1-i;
            int h=a[x];
            a[x]=a[0];
            a[0]=h;
            adjust(a,0,x-1);
        }


    }

    private static void adjust(int[] a, int i, int limit ) {

        int L,R;
        while (true){
            L =2*i+1;
            R =L+1;
            int index =L;
            if (L<=limit){
                if (R<limit && a[L]>a[R]){
                    index=R;
                }
            }else{
                break;
            }
            if (a[i]>a[index]){
                change(a,i,index);
            }else break;
            i=index;
        }




    }

    private static void change(int[] a, int i, int index) {
        int x=a[i];
        a[i]=a[index];
        a[index]=x;
    }


}
