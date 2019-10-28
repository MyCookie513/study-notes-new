package Leetcode.面试;

import java.util.Arrays;

public class 归并排序 {
    public static void main(String[] args) {

        int[] a={5,6,2,8,3,9,10,25,32,65,10};
        merge_sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }



   static void merge_sort(int[] a,int s,int e){

        if (s==e)
            return;
        int x=(s+e)/2;
        merge_sort(a,s,x);
        merge_sort(a,x+1,e);
        int i=s,j=x+1;
        int[] b=new int[e-s+1];
        int h=0;
        while (i<=x && j<=e){
            if (a[i]>a[j]){
                b[h]=a[j];
                j++;
            }else{
                b[h]=a[i];
                i++;
            }
            h++;
        }
        while (i<=x){
            b[h]=a[i];
            i++;
            h++;
        }

        while (j<=e){
            b[h]=a[j];
            j++;
            h++;
        }
        for (int k = 0; k < b.length; k++) {
            a[s]=b[k];
            s++;
        }

    }


}
