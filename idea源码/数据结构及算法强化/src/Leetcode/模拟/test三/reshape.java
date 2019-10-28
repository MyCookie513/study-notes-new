package Leetcode.模拟.test三;

public class reshape {


    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums==null)
            return null;
        int x=nums.length;
        int y=nums[0].length;
        if (r*c!=x*y){
            return nums;
        }

        int[][] a=new int[r][c];

        int x0=0,y0=0;
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j < y; j++) {
                a[x0][y0]=nums[i][j];
                y0++;
                if (y0==c){
                    y0=0;
                    x0++;
                }
            }
        }

        return a;
    }

}
