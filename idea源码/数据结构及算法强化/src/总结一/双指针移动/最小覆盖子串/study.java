package 总结一.双指针移动.最小覆盖子串;

//https://leetcode-cn.com/problems/minimum-window-substring/submissions/



public class study {

    public String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();

        int[] pMap = new int[128];

        int i = 0, j = 0; // 考察窗口[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1,l = 0,r = 0;

        //遍历子串,map 计数
        for (char pChar : pChars) {
            pMap[pChar]++;
        }


        while (j < sChars.length) {
            //减小计数
            if (pMap[sChars[j]] > 0)
                count--;

            //todo  一箭双雕： 1.如果为子串字母，将子串数目减一，标记为已经有了。
            // 2.如果是其他字符，则也标记 ，让慢指针能够知道走到这个字母时可以自动忽略；
            pMap[sChars[j]]--;

            j++;

            while (count == 0) {
                //求得一个解
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }

                //todo
                pMap[sChars[i]]++;
                // 增加计数
                if (pMap[sChars[i]] > 0) {
                    count++;
                    System.out.println(sChars[i]);
                }

                i++;
            }

        }


        return minLen == s.length() + 1 ? "" : s.substring(l, r);
    }

}
