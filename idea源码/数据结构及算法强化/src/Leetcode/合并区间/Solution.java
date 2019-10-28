package Leetcode.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {

                return a[0]-b[0];
            }
        });


        //todo 现在是排完序之后
        int[][] b=new int[intervals.length ][2];

        int b_num=0;
        for (int i = 0; i < intervals.length; i++) {
            b[b_num][0]=intervals[i][0];
            while (true){
                if (i+1<intervals.length && intervals[i][1] >=intervals[i+1][0]){
                    if ( intervals[i][1] >intervals[i+1][1] )
                        intervals[i+1][1]=intervals[i][1];
                    i++;
                }else{
                    b[b_num][1]=intervals[i][1];
                    b_num++;
                    break;
                }
            }
        }

        int[][] result =new int[b_num][2];
        for (int i = 0; i <b_num ; i++) {
            result[i]=b[i];
        }
        return result;
    }
}