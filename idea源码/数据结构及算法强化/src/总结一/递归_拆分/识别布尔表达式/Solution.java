package 总结一.递归_拆分.识别布尔表达式;

import java.util.ArrayList;
import java.util.List;



public class Solution {





    public static void main(String[] args) {
        //System.out.println( parseBoolExpr("&(f)"));
        split_String("&(&(f)),&(f,&(t))").stream().forEach((str)->{
            System.out.println(str);
        });
    }




    public static  boolean parseBoolExpr(String expression) {
        return  parse(expression);
    }

    private static  boolean parse(String exp) {
        //todo 递归的出口
        char c0=exp.charAt(0);
        if(exp.length()==1){
            switch (c0){
                case 't' : return true;
                case 'f' : return false;
            }
        }
        String ss=exp.substring(2,exp.length()-1);

        //todo ！ 单值 判定
        if (c0 == '!') {
            return !parse(ss);
        }

        //todo & and | 多值判定
        List<String> list=chafen(ss);
        if (c0=='&'){
            for (int i = 0; i < list.size(); i++) {
                if (!parse(list.get(i)))
                    return false;
            }
            return true;
        }else if (c0=='|'){
            for (int i = 0; i < list.size(); i++) {
                if (parse(list.get(i)))
                    return true;
            }
            return false;
        }

        return false;
    }


    /**
     * todo  这部分算法写的比较好 ：&（&（f）） ,&(f,&(t)) 一层拆分
     *
     */
  static List<String>  chafen(String ss){
        //todo 多值判定
        List<String> list=new ArrayList<>();
        //todo 对 ss 进行拆分；
        char target = ',';
        char[] c=ss.toCharArray();
        int s=0,e=0;
        int jishu=0;

        while (e<c.length){
            if (c[e] == target) {
                list.add(ss.substring(s,e));
                s=e+1;
            }else if (c[e]=='('){
                jishu++;
                target='0';
            }else if(c[e]==')'){
                if ( jishu==1)
                target=',';

                jishu--;
            }
            e++;
        }

        list.add(ss.substring(s,e));

        return list;
    }









   // &（&（f）） ,&(f,&(t)) 一层拆分

    static List<String > split_String (String exp){

      List<String > list=new ArrayList<>();

      char[] c=exp.toCharArray();

      int i=0,num =0,start=0;
      char target =',';
      while (i<c.length){
          if (c[i] == '(') {
              target='0';
              num++;
          }else if (c[i]==')'){
              if (num==1){
                  target=',';
              }
              num--;
          }else if (c[i]==target){
              list.add(exp.substring(start,i));
              start=i+1;
          }
          i++;
      }

      list.add(exp.substring(start,i-1));

      return list;

    }







}
