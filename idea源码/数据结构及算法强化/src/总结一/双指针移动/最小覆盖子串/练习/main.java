package 总结一.双指针移动.最小覆盖子串.练习;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class main {


    /***
     *
     *
     *出了一万个错误：
     *   1. x++； 切记  不是 x+1
     *   2.思路错误： todo 达标的界限判定错误；
     */
    public String minWindow(String s, String t) {

        if (s.equals(""))
            return "";


        char[] ss = s.toCharArray();
        //todo 误区: tt 匹配串中可能含有 重复的字符；
        char[] tt = t.toCharArray();

        //todo 难点如何 知道不满足条件； 设置满足条件的一个水准； 变化时依据这个水准进行判定；

        Map<Character,Integer> map =new HashMap<>();
        //设置一个 map来存储这些数据；相当于这个标准
        for (int i = 0; i < tt.length; i++) {
            int x=map.getOrDefault(tt[i],0);
            map.put(tt[i],x+1);
        }

        Map<Character,Integer> mp =new HashMap<>();
        int S=0,E=0;

        int i=0,max=map.size(); //计数 是否模板中的每个字母都达标
        int min = Integer.MAX_VALUE;
        int SS = 0;
        while (true){

            while (E<ss.length && i<max){
                if (map.containsKey(ss[E])){
                    int x=mp.getOrDefault(ss[E],0);
                    mp.put(ss[E],x+1);
                    if ( x+1 ==map.get(ss[E])) {
                            i++;
                    }
                }
                E++;
            }


            if (i != max) {
                break;
            }

            while (i==max){
                if (map.containsKey(ss[S])){
                    int x=mp.get(ss[S])-1;
                    mp.put(ss[S],x);

                    if (x<map.get(ss[S]))
                        i--;
                }
                S++;
            }


            int x=E-S+1;

            if (x<min){
                min=x;
                SS=S-1;
            }

        }

        if (min==Integer.MAX_VALUE){
            return "";
        }

        System.out.println(SS +"  "+min);
        return s.substring(SS,SS+min);

    }




}
