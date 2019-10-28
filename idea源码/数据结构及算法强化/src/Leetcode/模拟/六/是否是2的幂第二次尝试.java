package Leetcode.模拟.六;

import java.util.ArrayList;
import java.util.List;

public class 是否是2的幂第二次尝试 {

    public boolean reorderedPowerOf2(int N) {
        if (N==1 || N==2||N==4 ||N==8)
            return true;

        List<Integer> list =new ArrayList<>();

        char[] c =String.valueOf(N).toCharArray();
        int[] a=new int[10];
        for (int i = 0; i <c.length ; i++) {
            a[c[i]-'0']++;
        }
        double g=  Math.pow(10,c.length-1);
       // System.out.println(g);
        int start_2 = (int) (Math.log(g)/Math.log(2));
        double start=  Math.pow(2,start_2);
       System.out.println(start);


        while (true){
            if (start>=g*10)
                break;
            if (start>g ){
                if(verify(start,a))
                {
                    return true;
                }
            }
            start=start*2;
        }


        return false;
    }

    private boolean verify(double start, int[] b) {
        int x= (int) start;
        int[] a=new int[10];
        char[] c=String.valueOf(x).toCharArray();
        for (int i = 0; i < c.length; i++) {

            a[c[i]-'0']++;
        }

        for (int i = 0; i <10 ; i++) {
            if (a[i]!=b[i])
                return false;
        }
        return true;

    }

}
