package 总结一.动态规划.一个字符串中的最长回文字串;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        System.out.println(longestPalindrome("aacdefcaa"));
    }

    /**
     * 下面是第一次尝试时，错误的解法： 所认为一个字符串中的最长回文字串就是
     * 将字符串倒置后的字串 P ： 与原字符串的最长相同字串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s.length()==0)
            return "";
        if (s.length()==1)
            return s;
        char[] c=s.toCharArray();
        char[] p=new StringBuilder(s).reverse().toString().toCharArray();
        List<Character> list=new ArrayList<>();
        int max=0; List<Character> maxstr = null;
        for (int i0=c.length;i0>=-c.length+2;i0--){
            int j=0;int i=i0;
            while (i<c.length&&j<c.length){
                if(i<0){
                    i++;
                    j++;
                    continue;
                }
                if (c[j]==p[i]){
                    list.add(c[j]);

                    if (list.size()>max){
                        max=list.size();
                        maxstr=new ArrayList<>(list);
                    }
                    i++;
                    j++;
                }else{

                    list.clear();
                    i++;
                    j++;
                }

            }
            list.clear();
        }

        StringBuilder stringBuilder=new StringBuilder("");
        for (int i=0;i<maxstr.size();i++){
            stringBuilder.append(maxstr.get(i));
        }





        return stringBuilder.toString();
    }


    /***
     * 第二次尝试：
     * dynamic   规划
     *
     *
     * 状态方程:  由  small ----> big  的过程；
     * H(i,j)=(c[i]==c[j])&&((j-i<=2)||H(i+1,j-1));
     */


    public static String  dynamic (String str){

        if (str.length()<=1)
            return str;
        char[] c=str.toCharArray();
        int len=str.length();
        boolean[][] b=new boolean[len][len];
        int max=0;String max_str = str.substring(0,1);
        for (int r=1;r<len;r++){
            for (int l=0;l<r;l++){
                if ((c[l]==c[r])&&((r-l<=2)||b[l+1][r-1])) {
                    b[l][r] = true;
                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        max_str = str.substring(l, r + 1);
                    }
                }
            }
        }
        return max_str;

    }


    /**
     * 除此之外，还可以进行  --->中心扩展法
     */



}
