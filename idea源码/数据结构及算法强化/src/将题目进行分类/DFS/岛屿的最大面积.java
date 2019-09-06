package 将题目进行分类.DFS;


public class 岛屿的最大面积 {


    private  int[][] FX={{0,1},{0,-1},{1,0},{-1,0}};

    public int maxAreaOfIsland(int[][] grid) {

        int x=grid.length;
        int y=grid[0].length;
        System.out.println(x+"/" +y);
        boolean[][] isused =new boolean[x][y];
        int max=0;
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (grid[i][j]==1 && isused[i][j]==false){
                    max=Math.max(max,ruqin(i,j,grid,isused)+1);
                }
            }
        }
        return max;

    }

    private int ruqin(int x, int y, int[][] grid, boolean[][] isused) {
        int he=0;
        isused[x][y]=true;
        for (int i=0;i<4;i++){
            int x0=x+FX[i][0];
            int y0=y+FX[i][1];
            if (x0>=0 && x0<grid.length && y0>=0 && y0<grid[0].length){
                if (grid[x0][y0]==1 && isused[x0][y0]==false )
                    he+=1+ruqin(x0,y0,grid,isused);
            }
        }

        return he;
    }

    public int areaSum(int[][] grid, int i, int j){
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j]==1){
            grid[i][j] = 0;
            int ss = 1+areaSum(grid,i+1,j)+areaSum(grid,i-1,j)+areaSum(grid,i,j+1)+areaSum(grid,i,j-1);
            return ss;
        }

        return 0;
    }





}









