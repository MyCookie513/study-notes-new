package 字节跳动;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );

        char[] c=sc.next().toCharArray();


        digui(0,c,"");

/*

        for (int i =0;i<=n;i++){

        }
*/


    }

    private static void digui(int i, char[] c,String s) {


        if (i>= c.length) {
            System.out.println(s);
            return;
        }
       // System.out.println(i);

        digui(i+1,c,s+(char)(c[i]+16));

        if (i+1<c.length) {
            char c0= (char) (Integer.parseInt(c[i]+""+c[i+1])+64);
            digui(i + 2, c, s +c0);
        }
    }


}
