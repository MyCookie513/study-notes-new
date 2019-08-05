package DP;

public class 组合硬币 {


    public static void main(String[] args) {

        int[] a={1,2,5};

        System.out.println(change(5,a));

    }

    /**
     * dp【i】【j】 ：代表的是前i个硬币可拼凑出 j 元的种类；
     * dp[i][j]==前i-1个硬币可拼凑出j元的种类  +  前i个硬币拼凑出j-当前面值   的种类
     * dp[i][j]==dp[i-1][j]  +  dp[i][j-coin[i-1]] ;
     * @param amount    要拼凑成的目标钱数；
     * @param coins     可用的硬币面值有哪些
     * @return
     */
    public static int change(int amount, int[] coins) {
        int length=coins.length;
        //初始化二维dp表
        int[][] dp=new int[length+1][amount+1];
        for(int i=0;i<=length;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=length;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j]  +  ( j>=coins[i-1] ? dp[i][j-coins[i-1]] : 0 );
            }
        }

       /* for(int i=0;i<=length;i++){
            for(int j=0;j<=amount;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/

        return dp[length][amount];
    }


}
