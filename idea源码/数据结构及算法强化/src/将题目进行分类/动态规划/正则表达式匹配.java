package 将题目进行分类.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi","mis*is*ip*.*"));
    }

    public static boolean isMatch(String s, String p) {

        char[] sc=s.toCharArray();
        //将p模式串进行解析
        Object[] pc=solve(p);

        System.out.println(Arrays.toString(pc));

        boolean[][] a=new boolean[pc.length+1][s.length()+1];
        int x=1;
        //初始化第一列的数值；
        while (x-1<pc.length){
            if ((char)pc[x-1]=='*' ||  ((char)pc[x-1]>='A'&&(char)pc[x-1]<='Z')){

               a[x][0]=true;
                x++;
            }else{
                break;
            }
        }
        a[0][0]=true;

        //依次进行尝试性的匹配
        for (int i=1;i<=pc.length;i++){

            char pp=(char)pc[i-1];
            for (int j=1;j<=sc.length;j++){
                if ('*' ==pp){

                    a[i][j]=a[i-1][j-1] || a[i-1][j]|| a[i][j-1];     }else if ( (pp>='A'&&pp<='Z')){
                    if ((pp+32)==sc[j-1]){
                        a[i][j]=a[i-1][j-1] || a[i-1][j]|| a[i][j-1];
                    }else
                        a[i][j]=a[i-1][j];
                }else{
                    if (pp==sc[j-1]||pp=='.'){
                        a[i][j]=a[i-1][j-1];
                    }else
                        a[i][j]=false;
                }
            }
        }
       /* for (int i=0;i<=pc.length;i++) {
            System.out.print(Arrays.toString(a[i]));
            System.out.println();
        }*/

        return a[pc.length][sc.length];
    }

    private static Object[] solve(String p) {
        List<Character> list=new ArrayList<Character>();
        for (int i=0;i<p.length();){
            if (p.charAt(i)=='.'){
                if (i+1<p.length()&&p.charAt(i+1)=='*'){
                    list.add('*');//代表任意的字符任意的长度
                    i+=2;
                }else{
                    list.add('.');//代表任意的单个字符
                    i++;
                }
            }else{
                if (i+1<p.length()&&p.charAt(i+1)=='*'){
                    list.add((char) (p.charAt(i)-32));//代表任意的字符任意的长度
                    i+=2;
                }else{
                    list.add(p.charAt(i));//代表任意的单个字符
                    i++;
                }
            }
        }
        return list.toArray();

    }





}
