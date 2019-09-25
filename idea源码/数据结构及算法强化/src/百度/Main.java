package 百度;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long  n =Long.valueOf(sc.next()) ;
        long m =Long.valueOf(sc.next()) ;
        long k =Long.valueOf(sc.next()) ;


        long a0 = Math.min(n, m);

        long b0 = Math.max(n, m);
        long e = a0, s = 0;


        while (true) {

            if (e == s)
                break;
            long x = (e + s) / 2;
            if ((a0 - x) * b0 <= k) {
                e = x;
            } else {
                s = x + 1;
            }
        }
        if ((a0 - e) * b0 <= k) {
            System.out.println((a0-e)+"    b0:"+b0);

            System.out.println(e);
        }
    }



}
