package 排序;

import java.util.Arrays;


/**
 * 重要的还是一个点动态适应大顶堆的过程；
 */
public class 堆排序
{

    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 根据数组建立一个大顶heap
     * 那麽什么是一个大顶堆呢？
     * 1.是一个完全二叉树： （1）x*2 +1为左子树       （2） a.length/2-1    :      为最后一个非叶子节点；
     * 2. 父节点永远都比任何一个子节点都大
     * @param a
     */
    private static void heapSort(int[] a) {

        //第一步： 根据数组建立一个合法的大顶堆；

        for(int i=a.length/2-1;i>=0;i--){
            adustHeap(a,i,a.length-1);
        }
        System.out.println(Arrays.toString(a));

        //第二步： 每次都把大顶堆的head 拿走，拿n-1次这样就形成了一个从小到大的排序了；

        for(int i=a.length-1;i>0;i--){

            swap(a,i,0);
            adustHeap(a,0,i-1);
        }

    }

    /**
     *确定父节点能够大于子节点；
     */
    private static void adustHeap(int[] a,int i, int length) {
        int x = i * 2;
        while(x+1<=length) {

            if (x + 2 <= length && a[x + 2] >= a[x +1])
               x=x+2;
            else
               x=x+1;


            if(a[i]<a[x]) {
                swap(a, i, x);
                i=x;
                x*=2;
            }else
                break;

        }
    }

    private static void swap(int[] a, int i, int i1) {
        int temp=a[i];
        a[i]=a[i1];
        a[i1]=temp;
    }


}
