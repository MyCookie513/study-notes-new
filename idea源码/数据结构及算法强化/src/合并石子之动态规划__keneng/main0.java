package 合并石子之动态规划__keneng;
/*
 * 一维数组进行存储线上的石子；
 * 
 * 二维数组存储DP推算的过程；
 * 子问题：有各种相邻的堆数；二吨，三墩，，，，
 * 有从小到大的各种堆数的组合；
 * 每一种堆数有不同的位置
 * 在一个位置上又有不同的合并方式；
 * 然后选取最小的一个赋值；
 * 
 */
import java.util.Arrays;
import java.util.Scanner;

public class main0 {

	public static void DP_Stone(int[][] dp, int[] sum) {
		int j = 0, temp = 0;
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][i] = 0;
		}
		//从小到大依次计算出划分两堆，三堆，，，，到目标堆数的情况；
		for (int len = 2; len <= dp.length; len++) { // 划分的石子堆数
			
            //每x堆在不同的位置；都要进行计算出来；
			for (int i = 0; i < dp.length - len + 1; i++) {
				j = i + len - 1;
                //在可能的合堆方式中选取最少的那个进行赋值；
				for (int k = i; k < j; k++) {
					temp = dp[i][k] + dp[k + 1][j] + sum[j] - (i == 0 ? 0 : sum[i - 1]);
					dp[i][j] = Math.min(dp[i][j], temp);// System.out.println(i+","+j+" : "+dp[i][j]);
				}
			}
			
			
		}
	}

	public static void main(String[] args) {

		Scanner scam = new Scanner(System.in);
		int n = scam.nextInt();
		int[] sum = new int[n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < sum.length; i++) {
			if (i == 0)
				sum[i] = scam.nextInt();
			else
				sum[i] = sum[i - 1] + scam.nextInt();
		}
		DP_Stone(dp, sum);
		System.out.println(dp[0][n - 1]);
	}
}
