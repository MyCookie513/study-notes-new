package 总结一.DFS;


/**
 * 题目链接： https://leetcode-cn.com/submissions/detail/28415378/
 */

public class 岛屿的最大面积 {

    private  int[][] FX={{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int max =0;
        for(int i = 0; i < grid.length;i ++){
            for(int j = 0; j < grid[0].length;j ++){
                if(grid[i][j] == 1){
                    max = Math.max(areaSum(grid,i,j),max);
                }
            }
        }
        return max;
    }

    /**
     * DFS : 递归搜索；
     *                  1） 进入函数后先进行判定 此点 是否有效
     *                  2） 然后再进行 尝试性 走下一步 （递归下一个函数）
     *
     *
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public int areaSum(int[][] grid, int i, int j){
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j]==1){
            grid[i][j] = 0;
            int ss = 1+areaSum(grid,i+1,j)+areaSum(grid,i-1,j)+areaSum(grid,i,j+1)+areaSum(grid,i,j-1);
            return ss;
        }

        return 0;
    }



}









