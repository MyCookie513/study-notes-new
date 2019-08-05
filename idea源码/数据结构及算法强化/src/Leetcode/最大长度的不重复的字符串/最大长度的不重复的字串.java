package Leetcode.最大长度的不重复的字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * DIY：　动态的循环＋map集合判定重复性
 */
public class 最大长度的不重复的字串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] c=s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int start=0,max=0;
        for (int i=0;i<c.length;){
            if (map.containsKey(c[i])&&map.get(c[i])>=start){
                max=Math.max(max,i-start);
                start=map.get(c[i])+1;
                map.remove(c[i]);
            }else{
                map.put(c[i],i);
                i++;
            }

        }
        max=Math.max(max,c.length-start);


        return  max ;

    }
}
