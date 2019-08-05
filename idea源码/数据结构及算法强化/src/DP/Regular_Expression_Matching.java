package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Regular_Expression_Matching {


    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
        String s=sc.next();
        String p=sc.next();


        System.out.println(isMatch(s,p));

    }


    /**
     * caaaadgcxxd
     * ca*aad.c.*d
     * Z:90   a:97   A  . 为特殊 96 为普通
     * @param s0
     * @param p0
     * @return
     */
    public static boolean isMatch(String s0, String p0) {

        char[] s=s0.toCharArray();
        char[] p=p0.toCharArray();
        List<Character> C=new ArrayList<>();
        /*将P模板字符进行整理便于进行匹配*/
        for(int i=0;i<p.length;){
            if(i+1>=p.length||p[i+1]!='*') {
                if(p[i]!='.')
                    C.add(p[i]);
                else
                    C.add((char)96);
                i++;
            }else {
                if(p[i]!='.')
                    C.add((char) (p[i] - 32));
                else
                    C.add('.');

                i+=2;
            }
        }

        Object[]  mb= C.toArray();
       // System.out.println(C.toString());

        //初始一部分判定值；
        boolean[][] b=new boolean[s.length+1][mb.length+1];
        b[0][0]=true;
        int x=0;
        while (x<mb.length&&((char)mb[x])<91){
            b[0][x+1]=true;
            x++;
        }

        //开始动态规划的一步一步优先选择
        for(int i=0;i<s.length;i++){
            for(int j=0;j<mb.length;j++){
                if((char)mb[j]<='Z'){
                    if((char)mb[j]==(s[i]-32)||(char)mb[j]=='.'){
                        if(b[i][j]==true||b[i][j+1]==true||b[i+1][j]==true)
                            b[i+1][j+1]=true;
                        else
                            b[i+1][j+1]=false;
                    }else{
                        if(b[i+1][j]==true)
                            b[i+1][j+1]=true;
                        else
                            b[i+1][j+1]=false;
                    }

                }else{
                    if((char)mb[j]==s[i]||(char)mb[j]==(char)96){
                        if(b[i][j]==true)
                            b[i+1][j+1]=true;
                        else
                            b[i+1][j+1]=false;
                    }else{

                            b[i+1][j+1]=false;
                    }

                }

            }
        }


        /*for(int i=0;i<=s.length;i++){
            System.out.println(Arrays.toString(b[i]));
        }*/

        return  b[s.length][mb.length];
    }



}
