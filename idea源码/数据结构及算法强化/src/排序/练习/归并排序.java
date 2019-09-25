package 排序.练习;

import java.util.Arrays;

public class 归并排序 {


    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        merge(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }



    private static void merge(int[] a, int S, int E) {
        if (S==E)
            return;

        //todo 分
        int zhong =(S+E)/2;
        merge(a,S,zhong);
        merge(a,zhong+1,E);
        //todo 合
        int[] b=new int[E-S+1];
        int i=S,j=zhong+1,b0=0;
        while (i<=zhong && j<=E){
            if (a[i]>a[j]) {
                b[b0] = a[j];
                j++;
            }else{
                b[b0] = a[i];
                i++;
            }
            b0++;

        }
        while (i<=zhong){
            b[b0]=a[i];
            i++;
            b0++;
        }
        while (j<=E){
            b[b0]=a[j];
            j++;
            b0++;
        }

        //todo
        b0=0;
        for (int k = S; k<=E; k++) {
            a[k]=b[b0];
            b0++;
        }


    }


}
