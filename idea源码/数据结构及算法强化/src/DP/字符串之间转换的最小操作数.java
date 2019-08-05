package DP;

import java.util.Scanner;
//https://leetcode.com/problems/edit-distance/description/
public class 字符串之间转换的最小操作数 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strOld=in.next();
        String strNew=in.next();

        int x=Strmethod (strOld,strNew);


    }

    private static int Strmethod(String strOld, String strNew) {

        char[] p=strOld.toCharArray();
        char[] q=strNew.toCharArray();
        int[][] a=new int[p.length+1][q.length+1];
        //根据题意将二维数组进行初始化
        for(int i=1;i<p.length+1;i++){
            a[i][0]=i;
        }

        for(int i=1;i<q.length+1;i++){
            a[0][i]=i;
        }

        //由二维数组进行动态规划
        for(int i=1;i<=p.length;i++){
            for(int j=1;j<=q.length;j++){
                if(p[i-1]==q[j-1])
                    a[i][j]=a[i-1][j-1];
                else
                    a[i][j]=Math.min(Math.min(a[i][j-1],a[i-1][j-1]),a[i-1][j])+1;
            }
        }

        //由二维数组进行动态规划
       /* for(int i=0;i<=p.length;i++){
            for(int j=0;j<=q.length;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }*/

        return a[p.length][q.length];
    }


}
