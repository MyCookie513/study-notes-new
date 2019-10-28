package 总结一.栈.最长有效括号;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {


    private int index=0;


    /**
     * todo 可以通过入栈的方式进行匹配；
     * @param s
     * @return
     */

    public int longestValidParentheses(String s) {
        char[] c=s.toCharArray();
        int result=0;

        while (index<c.length){
            if (c[index]=='(') {
                get_P(c);
            }else {
                index++;
            }
        }

        System.out.println(Arrays.toString(c));
        int num=0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='A')
                num++;
            else{
                if (num>result)
                    result=num;
                num=0;
            }
        }
        if (num>result)
            result=num;
        return result;
    }

    //一次性的追寻直到失败
    private boolean get_P(char[] c) {

        boolean b=false;
        int y=index;
        index++;
        while (index<c.length){
            if (c[index] == ')') {
                c[y]='A';
                c[index]='A';
                b=true;
                break;
            }else {
                boolean b0=get_P(c);
                if (!b0)
                    return false;
                index++;
            }
        }
        return b;

    }

    /**
     * //todo 比较简单的用栈来解决
     *
     * @param s
     * @return
     */
    public int longestValidParentheses0(String s) {

        LinkedList<Integer> list=new LinkedList<>();
        char[] c=s.toCharArray();


        for (int i = 0; i < c.length; i++) {
            if (c[i]=='(')
                list.addFirst(i);
            else{
                if (!list.isEmpty()) {
                    int x = list.removeFirst();
                    c[i]='A';
                    c[x]='A';
                }
             }
        }

        int num=0;
        int result=0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]=='A')
                num++;
            else{
                if (num>result)
                    result=num;
                num=0;
            }
        }
        if (num>result)
            result=num;
        return result;

    }
}
