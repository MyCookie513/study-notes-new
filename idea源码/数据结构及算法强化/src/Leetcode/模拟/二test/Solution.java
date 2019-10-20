package Leetcode.模拟.二test;

import java.util.Random;

class Solution {


    /**
     * 题目链接： https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles/submissions/
     *
     * todo 题意：　面积不一的多个矩形　　看作一个整体　来随机抽取矩形内的点；
     * todo 思路：  每个矩形一个频段， 从总的点中抽取一个点，然后在遍历所有的矩形，看是否 属于这个矩形，然后进行再在这个矩形中随机抽取一个点
     *
     *
     *
     */

    private Random random=new Random();

    private int[][] a;
    private int[][] b; //todo 记录每个矩形的范围

    private int i=0;

    int x=1;
    public Solution(int[][] rects) {
        a=rects;
        b=new int[rects.length][2];

        for (int j = 0; j < rects.length; j++) {
            int s=(rects[j][2]-rects[j][0]+1)*(rects[j][3]-rects[j][1]+1);
            int ss=x;
            x=x+s;
            b[j][0]=ss;
            b[j][1]=x;    // todo s<= dian < e

        }
    }

    public int[] pick() {


        int p=random.nextInt(x);

        for (int j = 0; j <a.length ; j++) {
            if (p>=b[j][0] && p<b[j][1]){
                i=j;
                break;
            }
        }


        int[] b=new int[2];
        int x=a[i][2]-a[i][0];
        int y=a[i][3]-a[i][1];
        b[0]=  random.nextInt(x+1)+a[i][0];
        b[1]=  random.nextInt(y+1)+a[i][1];

        return b;
    }


}
