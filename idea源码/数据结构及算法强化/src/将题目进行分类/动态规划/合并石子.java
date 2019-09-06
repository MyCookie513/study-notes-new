package 将题目进行分类.动态规划;

import java.util.Scanner;

public class 合并石子 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len =sc.nextInt();
        int[] a=new int[len];
        int[] sum = new int[len];
        int[][] b=new int[len][len];

        for (int i = 0; i < sum.length; i++) {
            if (i == 0)
                sum[i] = sc.nextInt();
            else
                sum[i] = sum[i - 1] + sc.nextInt();
        }
        //2--》n 堆
        for (int i=2;i<=len;i++){
            //内部合并
            for (int j=i-1;j<len;j++){
                int s=j-i+1;
                int min=Integer.MAX_VALUE,h;
                for (int x=s;x<j;x++){
                    h=b[s][x]+b[x+1][j]+sum[j] - (s == 0 ? 0 : sum[s - 1]);
                    if (h<min)
                        min=h;
                }
                b[s][j]=min;
            }
        }


        System.out.println(b[0][len-1]);

    }
}
