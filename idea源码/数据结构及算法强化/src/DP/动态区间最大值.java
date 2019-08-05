package DP;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * https://leetcode.com/problems/maximum-subarray/
 */
public class 动态区间最大值 {


    private static int res;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = in.nextInt();
        int kase = 0;
        while (T-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            int[] ends = new int[arr.length];
            ends[0] = arr[0];
            int max = ends[0], maxi = 0;
            for (int i = 1; i < arr.length; i++) {
                ends[i] = ends[i - 1] > 0 ? ends[i - 1] + arr[i] : arr[i];
                if (ends[i] > max) {
                    max = ends[i];
                    maxi = i;
                }
            }
            int curSum = max, L = maxi; // L 是左边界
            for (int i = maxi; i >= 0; i--) {
                curSum -= arr[i];
                if (curSum == 0) {
                    L = Math.min(L, i);
                }
            }
            out.println("Case " + (++kase) + ":");
            out.println(max + " " + (L + 1) + " " + (maxi + 1));
            if (T != 0) out.println();
        }
        out.close();
    }

    public static int maxSubArray(int[] nums) {

        int[] ends = new int[nums.length];
        ends[0] = nums[0];
        int max = ends[0];
        for (int i = 1; i < nums.length; i++) {
            ends[i] = ends[i - 1] > 0 ? ends[i - 1] + nums[i] : nums[i];
            max = Math.max(max, ends[i]);
        }
        return max;
    }



}
