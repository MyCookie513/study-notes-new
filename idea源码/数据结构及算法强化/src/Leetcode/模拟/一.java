package Leetcode.模拟;

import java.util.Arrays;

public class 一 {

    public static void main(String[] args) {
        boolean[] b=new boolean[3];
        boolean[] n=b.clone();
        b[0]=true;
        System.out.println(n[0]);
        System.out.println(Arrays.toString(b));
    }

}
