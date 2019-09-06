package 将题目进行分类.动态规划;

public class 是否是回文数 {


    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
    }

    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        String str=""+x;
        int i=0,j=str.length()-1;
        while (i<j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
