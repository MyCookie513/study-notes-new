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

        for (int i=1;i<len;i++){
            
        }

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
