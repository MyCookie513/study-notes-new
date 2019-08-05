package DP;

import java.util.Scanner;

public class 非连续_最长公共字串 {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str1=scanner.next();


        int result=max_string(str1);
        System.out.println(result);
    }

    private static int max_string(String str1) {
        char[] p=str1.toCharArray();
        char[] q=new char[p.length];
        for (int i=0;i<p.length;i++){
            q[i]=p[p.length-1-i];
        }

        int[][] a=new int[p.length+1][p.length+1];

        for(int i=0;i<p.length;i++){
            for(int j=0;j<p.length;j++){
                if(p[i]==q[j]){
                    a[i+1][j+1]=a[i][j]+1;
                }else{
                    a[i+1][j+1]=Math.max(a[i+1][j],a[i][j+1]);
                }
            }
        }

        return a[p.length][p.length];

    }







}
