package 总结一.经典问题.通配符匹配.官方解法.动态规划;

/***
 * 思路二: 动态规划
 *
 * dp[i][j]表示s到i位置,p到j位置是否匹配!
 *
 * 初始化:
 *
 * dp[0][0]:什么都没有,所以为true
 * 第一行dp[0][j],换句话说,s为空,与p匹配,所以只要p开始为*才为true
 * 第一列dp[i][0],当然全部为False
 *
 * 动态方程:
 *
 * 如果(s[i] == p[j] || p[j] == "?") && dp[i-1][j-1] ,有dp[i][j] = true
 *
 * 如果p[j] == "*" && (dp[i-1][j] = true || dp[i][j-1] = true) 有dp[i][j] = true
 *
 * ​ note:
 *
 * ​ dp[i][j-1],表示*代表是空字符,例如ab,ab*
 *
 * ​ dp[i-1][j],表示*代表非空任何字符,例如abcd,ab*
 *
 */
public class Main {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        // todo   初始化
        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }


        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {

                //todo 核心： 动态转移方程
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }


            }
        }
        return dp[s.length()][p.length()];

    }


}
