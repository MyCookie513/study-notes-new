package KMP;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 理解题意： p 前面的字符和以q的任意一个起点的位置是否能匹配到结尾；
 */
public class 最短回文 {



    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        //第一种方法
      //  System.out.println(shortestPalindrome(str));
        //第二种方法
        int next=getNext(str+"#"+new StringBuilder(str).reverse().toString());
        System.out.println(new StringBuilder(str.substring(next,str.length())).reverse()+str);

    }


    /***】
     *根据这个交错相同的字符只能是在p的开头的一段字符串，在q结尾的一段字符串
     * 特点来写的一个算法
     * @param s
     * @return
     */

    public static  String shortestPalindrome(String s) {
        if(s.equals(""))
            return null;
        char[] p= s.toCharArray();
        int len=p.length;
        char[] q=s.toCharArray();
        char c;
        for (int i=0;i<(len>>1);i++){
            c=q[i];
            q[i]=q[len-1-i];
            q[len-1-i]=c;
        }

        int x=1;
        /*得到最大p和q最大的交错相同字符的数目，这个交错相同的字符只能是在p的开头的一段字符串，在q结尾的一段字符串*/
        for(int i=1;i<len;i++){
            int a=i;
            int b=len-1;
            boolean bl=true;
            while (a>=0) {
                if(p[a]!=q[b]){
                    bl=false;
                    break;
                }
                  a--;
                  b--;
            }
            if (bl==true){
                x=i+1;
            }

        }


        return String.valueOf(q).substring(0,len-x)+String.valueOf(p);
    }

    /**
     * 利用kmp算法找到与开头的最长匹配
     *
     * @param s
     * @return
     */

    public  static  int getNext(String s){

        char[] c=s.toCharArray();
        int[] next=new int[c.length+1];
        next[0]=-1;
        next[1]=0;
        for (int i=1;i<c.length;i++){
            int x=i;
            while(true){
                if(c[i]==c[next[x]]) {
                    next[i + 1] = next[x] + 1;
                    break;
                } else{
                    x=next[x];
                    if(next[x]==-1) {
                        next[i + 1] = 0;
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(next));
        return next[c.length];
    }




}
