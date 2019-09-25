package 总结一.经典问题.通配符匹配.官方解法.双指针法;


/**
 * 思路一: 利用两个指针进行遍历。
 *
 * 在代码里解释.
 *
 * 时间复杂度为:O(mn)
 *
 *
 * todo 双指针的常用模型 ：
 *      这道题指针走的逻辑为：
 *          指针正常往前走：    走到一个标记点   （中间可能有多个标记点）
 *                在往下走的时候，尝试性向前移动，如果失败则返回原点，改换下一个策略 进行 尝试性移动；
 *
 *
 *
 */
public class Main {

    public boolean isMatch(String s, String p) {

        int sn = s.length();
        int pn = p.length();

        //todo     i and j is 两个指针
        int i = 0;
        int j = 0;

        int start = -1;
        int match = 0;

        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {// todo 如果匹配到下一个* ，则前面的那个 * 进行替换；

                //　todo 开启进行吞噬匹配，将开启吞噬匹配的位置记录下啊，如果匹配错误，使其能够返回原匹配点
                start = j;

                //已经匹配到第i个字符（成功匹配了 i-1 个）
                match = i;

                //p 串 继续向右走
                j++;

            } else if (start != -1) { //todo 匹配失败了 ，还原上一个点 ，匹配串 右 移 一个，然后继续向下匹配

                j = start + 1;

                match++;

                i = match;

            } else {
                return false;
            }
        }

        /**
         * 说的是： S串成功匹配，P 串还没有走到结束，所以要验证是否 P 剩下是否都是＊　；
         */
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }

        return true;

    }




}
