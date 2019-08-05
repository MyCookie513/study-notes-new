package KMP;

import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 *题目：          求子串在主串的最小匹配位置；
 */
 class Kmp {
     public static void main(String[] args) {
         Scanner cin = new Scanner(new BufferedInputStream(System.in));
         int n = cin.nextInt();
         while(n-- > 0){
             String s = cin.next();//主串
             String p = cin.next();//匹配串
             System.out.println(kmp(s,p));
         }
     }
     /**题目：          求子串在主串的最小匹配位置；
      *主串中已经匹配的字符串相当于kmp中的头节点主串
      * @param s： 主字符串
      * @param p   子字符串
      * @return
      */
    static int kmp(String s,String p){/**/
        if(s == null || p == null || p.length() < 1 || s.length() < p.length() )
            return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = p.toCharArray();

        int i1 = 0,i2 = 0; //甲乙
        int[] next = getNext(str2);

        while(i1 < str1.length && i2 < str2.length){
            if(str1[i1] == str2[i2]){ //能配上，继续
                i1++; i2++;
            }else {
                if(next[i2] == -1) { //我str2到了第一个你都配不上,那你str1就下一个吧
                    i1++;
                }else {//逻辑概念是str2往右边推，next【i2】是在此字符前与本体匹配度最长的匹配字串
                    i2 = next[i2]; //来到next数组指示(最长公共前缀后缀)
                }
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * next数组代表的意义：从head节点开始的最大匹配长度；
     * （）可能会咬到自己尾巴，字符串中的字符从字符串的head开始进行尝试匹配，
     * 如果匹配成功则下一个字符承接向下继续匹配；
     * next数组的求法：
     *
     * @param str2
     * @return
     */
    static int[] getNext(char[] str2) {
        if(str2.length == 1)
            return new int[]{-1};
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;/*cn代表匹配到从head开始的第几个元素*/
        for(int i = 2; i < str2.length;){
            /*从第二个元素开始尝试匹配*/
            if(str2[i-1] == str2[cn]){
                /*如果匹配成功，i++，cn++继续向下匹配*/
                next[i++] = ++cn; //就是cn+1
            }else {
                /*如果匹配不成功*/
                if(cn > 0) /*如果不是匹配头节点失败，而是在匹配的过程中失败，因为匹配地位的相同，进行递归式匹配*/
                    cn = next[cn];
                else/*如果cn=0；也就是匹配到头节点都失败，直接返回0即可；推进到下一个字符进行匹配*/
                    next[i++] = 0;
            }
        }
        return next;
    }

}
