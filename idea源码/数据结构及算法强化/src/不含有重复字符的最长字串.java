import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 不含有重复字符的最长字串 {



    public int lengthOfLongestSubstring(String s) {
        char[] c=s.toCharArray();

        int[] res = new int[256];
        Arrays.fill(res, -1);
        int max=0;
        int youxiaodian =0;
        for (int i=0;i<c.length;i++){
            if (res[c[i]] != -1 && res[c[i]] >= youxiaodian){
                max=Math.max(max,i-youxiaodian);
                youxiaodian=res[c[i]]+1;
                res[c[i]]=i;
            }else{
                res[c[i]]=i;
            }
        }
        return Math.max(max,c.length-youxiaodian);
    }

}
