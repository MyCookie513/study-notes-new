package 总结一.DFS;


/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class 被围绕的区域 {


    private boolean[][] b;
    private int x,y;
    private char[][] board;
    public void solve(char[][] board) {

        if (board==null || board.length<=2)
            return;
        this.board=board;
        this.x =board.length-1;
        this.y=board[0].length-1;
        b=new boolean[x+1][y+1];

       for (int i=0;i<=y;i++){
           DFS(0,i);
           DFS(x,i);
       }
        for (int i=0;i<=x;i++){
            DFS(i,0);
            DFS(i,y);
        }

        for (int i=0;i<=x;i++){
            for (int j=0;j<=y;j++){
                if (b[i][j] == false && board[i][j]=='O' ){
                    board[i][j]='X';
                }
            }
        }

    }

    /**
     * 看与这个点联通的点中是否有 边界点，有则 不动 ，无则 改变符号
     * @param i
     * @param j
     * @param
     * @return
     */
    private void   DFS(int i, int j) {

        if (i>=0 && j>=0 &&i<=x && j<=y && board[i][j]=='O' && b[i][j]==false) {
            b[i][j]= true;
           DFS(i+1,j);
           DFS(i-1,j);
           DFS(i,j+1);
           DFS(i,j-1);
        }


    }

}
