package 排序;

import java.util.Arrays;

public class 基数排序 {
    public static void main(String[] args) {

        int[] a={525,62,2866,89,396,9,106,25,632,665,190};
        jishu(a);
        System.out.println(Arrays.toString(a));



    }

    private static void jishu(int[] a) {
        int len=getLen(a);
        System.out.println(len);
        int[] b=new int[a.length];
        for (int i=1;i<len;i++){
            int[] count =new int[10];
           for (int j=0;j<a.length;j++){
               int x=getDigit(a[j],i);
               count[x]++;
           }
           for (int t=1;t<10;t++){
               count[t]=count[t]+count[t-1];
           }

            for (int j=a.length-1;j>=0;j--){
                int x=getDigit(a[j],i);
                b[--count[x]]=a[j];
            }


            for (int j=0;j<a.length;j++){
                a[j]=b[j];
            }


            System.out.println(Arrays.toString(b));

        }

    }

    private static int getDigit(int x, int d) {
        return x/(int) Math.pow(10,(double)(d-1))%10;
    }

    private static int getLen(int[] a) {
        int max=0;
        for (int i=0;i<a.length;i++){
            if (String.valueOf(a[i]).length()>max)
                max=String.valueOf(a[i]).length();
        }
        return max;
    }



}
