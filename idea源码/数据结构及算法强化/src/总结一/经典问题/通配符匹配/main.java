package 总结一.经典问题.通配符匹配;

import java.util.Scanner;

public class main {


    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        String s =sc.next();
        String p =sc.next();
       boolean result= isMatch(s,p);


        System.out.println(result);


    }

    public static boolean isMatch(String s, String p) {

        char[]  ss=s.toCharArray();
        char[]  pp=p.toCharArray();
        if (pp.length==0){
            if(ss.length==0)
                return true;
            return false;
        }



       boolean result =  if_Match(0,ss,0,pp);
       return  result;
    }

    private static boolean if_Match(int s_start, char[] ss, int p_start, char[] pp) {

        System.out.println(s_start+"  "+p_start);
        //todo 两个指针向前推进，遇到* 递归匹配，？ ： if匹配失败直接返回
        int p_start0=p_start;
        int s_start0=s_start;
        for (; p_start0 <pp.length && s_start0<ss.length ; ) {
            if (pp[p_start0]=='?'){
                p_start0++;
                s_start0++;
            }else if (pp[p_start0]=='*'){

                while (p_start0<pp.length && pp[p_start0]=='*')
                    p_start0++;
                p_start0--;

                for (int i = s_start0; i <=ss.length; i++) {
                    //todo 错在这里
                   boolean re= if_Match(i,ss,p_start0+1,pp);
                   if (re==true)
                       return  true;
                }
                return false;

            }else if (pp[p_start0] == ss[s_start0]){
                p_start0++;
                s_start0++;
            }else{
                //System.out.println("匹配不相同"+p_start0+"   "+s_start0);
                return false;

            }
        }
        if (p_start0 == pp.length && s_start0==ss.length){
            return true;
        }else if(p_start0 < pp.length && s_start0==ss.length){
             while (p_start0<pp.length){
                 if (pp[p_start0]!='*'){
                     return false;
                 }
                 p_start0++;
             }
             return true;
        }else if(p_start0 ==pp.length && s_start0 <ss.length){
                if (pp[p_start0-1]=='*'){
                    return true;
                }else
                    return false;

        }else{
            return false;
        }

    }

}
