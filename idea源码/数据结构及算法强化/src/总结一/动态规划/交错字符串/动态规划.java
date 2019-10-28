package 总结一.动态规划.交错字符串;

import java.util.Arrays;

public class 动态规划 {

    public boolean isInterleave(String s1, String s2, String s3) {

        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();
        char[] c3=s3.toCharArray();
        if (c3.length !=(c1.length +c2.length))
            return  false;

        boolean[][] b=new boolean[c1.length+1][c2.length+1];

        b[0][0]=true;
        for (int i = 0; i <=c1.length ; i++) {
            for (int j = 0; j <=c2.length ; j++) {
               if (i==0){
                   if (j!=0)
                       b[i][j]=b[i][j-1] &&c2[j-1]==c3[i+j-1];
               }else if (j==0){
                   b[i][j]=b[i-1][j]&& c1[i-1]==c3[i+j-1];
               }else{
                   b[i][j]=(b[i-1][j]&& c1[i-1]==c3[i+j-1])||(b[i][j-1]&& c2[j-1]==c3[i+j-1]);
               }
            }
            System.out.println(Arrays.toString(b[i]));
        }

        return b[c1.length][c2.length];

    }
}
