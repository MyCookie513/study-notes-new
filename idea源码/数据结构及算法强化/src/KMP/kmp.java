package KMP;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;
/**
 *题目：          求子串在主串的最小匹配位置；
 */
 class Kmp {
    public static void main(String[] args) {
        String str = "bbb123dfs123563";
        System.out.println(tryPattern(str.toCharArray(),"bb".toCharArray()));
    }
    /**题目：          求子串在主串的最小匹配位置；
     *主串中已经匹配的字符串相当于kmp中的头节点主串
     */

    /**
     * 匹配失败返回-1，匹配成功返回字符串的开始匹配位置
     *
     * @return
     */

    static int tryPattern(char[] main, char[] pa) {

        int[] p = getHeadAndTail(pa);
        int x =0,i= 0;//pattern的匹配位置

        while (i < main.length && x < pa.length) {
            if (main[i] == pa[x]) {
                i++;
                x++;
            } else {
                if (p[x] == -1)
                    i++;
                else
                    x = p[x];
            }

        }
        if (x == pa.length)
            return i - x ;
        if (i == main.length)
            return -1;

        return 0;

}


    /**
     * small ---> big  : 每个字符串头和尾的匹配长度
     *
     * @param c
     * @return
     */
    static  int[]  getHeadAndTail(char[] c){
        int[] a=new int[c.length+1];
        a[0]=-1;
        for (int i=1;i<c.length;i++){
            int x=i;
            while (true){

                if (c[i]==c[a[x]]){
                    a[i+1]=a[x]+1;
                    break;
                }else{
                    x=a[x];
                    if (a[x]==-1)
                        break;
                }
            }
        }
        return a;
    }
}
