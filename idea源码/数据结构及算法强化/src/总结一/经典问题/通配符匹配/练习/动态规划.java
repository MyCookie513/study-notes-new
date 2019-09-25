package 总结一.经典问题.通配符匹配.练习;

public class 动态规划 {


    /**
     * 根据题意： 我们可以由前面的字符推出后面的字符是否能够进行匹配；
     *
     * 　ｂ［ｉ］［ｊ］　代表　ｓ　的前　ｉ个字符　和　ｐ　的前　ｊ　个字符是否能够进行匹配；
     *
     * P：
     * 　　普通字符：  前面的是否匹配 　&&　ｐ［ｉ］＝＝ｓ［ｊ］
     *
     * 　　？　　　：　前面是否能够匹配；
     *
     * 　　＊      ：
     *              * 可以甚麽都不匹配；  b[i-1][j]
     *              * 可以匹配多个：      b[i][j-1]
     *              * 仅匹配第j个字母；   b[i-1][j-1]
     *
     * @param s
     *
     * @param p
     *
     * @return
     */
    public boolean isMatch(String s, String p) {


        char[] ss=s.toCharArray();
        char[] pp=p.toCharArray();
        boolean[][] b=new boolean[ss.length+1][pp.length+1];

        b[0][0]=true;

        //初始化：
        int x=0;
        while (x<pp.length && pp[x]=='*'){
            b[0][++x]=true;
        }



        for (int i = 0; i < ss.length ; i++) {
            for (int j = 0; j < pp.length; j++) {

                if (pp[j]=='*'){

                    b[i+1][j+1]= b[i][j] || b[i][j+1] || b[i+1][j];

                }else if (pp[j]=='?'){

                    b[i+1][j+1]= b[i][j] ;

                }else{

                    b[i+1][j+1]= pp[j]==ss[i] && b[i][j]  ;

                }
                System.out.print( b[i+1][j+1]+" ");

            }
            System.out.println();
        }


        return b[ss.length][pp.length];

    }

}




