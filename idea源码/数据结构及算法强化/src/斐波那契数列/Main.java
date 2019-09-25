package 斐波那契数列;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n =sc.nextInt();

        int ss = (int)Math.pow(10, 9)  +7;

        //从 0，1 开始
        int a=1;int b=1;

        int x;
        for (int i = 3; i <=n; i++) {
            x=b;
            b=a+b;
            a=x;
            if (b>=ss)
                b=b%ss;
        }
        System.out.println(b);

    }
}
