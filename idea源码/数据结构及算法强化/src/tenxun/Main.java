package tenxun;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len1 = in.nextInt();
        int len2 = in.nextInt();
        int[] a=new int[len1];
        int[] b=new int[len2];
        for (int i=0;i<len1;i++){
            a[i]=in.nextInt();
        }
        for (int i=0;i<len2;i++){
            b[i]=in.nextInt();
        }


        System.out.println(tryPattern(a,b));

    }

    private static int  tryPattern(int[] a, int[] b) {

        int aji=0,aou=0,bji=0,bou=0;
        for (int i=0;i<a.length;i++){
            if (a[i]%2==0){
                aou++;
            }else
                aji++;
        }
        for (int i=0;i<b.length;i++){
            if (b[i]%2==0){
                bou++;
            }else
                bji++;
        }

        return Math.min(aji,bou)+Math.min(bji,aou);
    }
}
