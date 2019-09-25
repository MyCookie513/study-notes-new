package 斐波那契数列.矩阵求幂;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 矩阵求幂： 可以分解为两类问题：
 *
 * 　１.矩阵的相乘
 *
 * 　２.快速求幂问题；
 *
 *
 */
public class Main
{


    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        String str=sc.next();
        long r= Long.valueOf(str);

        long[][]  a={{1,1},{1,0}};
        long[][]  c;

        int ss = (int)Math.pow(10, 9)  +7;

        c=quickGetMi(a,r-1);

        long h= c[0][0]+c[0][1];
        if (h>ss)
            h=h%ss;
        System.out.println(h);



        for (int i = 0; i <c.length ; i++) {
            System.out.println(Arrays.toString(c[i]));
        }
    }



    /***
     * 矩阵的相乘；
     * @param a
     * @param b
     * @return
     */
    private static long[][] XiangCheng(long[][] a, long[][] b) {

        if (a==null || b==null || a[0].length!=b.length)
            return null;
        int ss = (int)Math.pow(10, 9)  +7;

        int n =a.length;
        int m =b[0].length;

        long[][] c=new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x=0;
                // 新矩阵中新个体元素的求出
                for (int k = 0; k <b.length ; k++) {

                    long y=a[i][k]*b[k][j];
                    if (y>ss)
                        y=y%ss;
                    x+=y;

                    if (x>ss)
                        x=x%ss;
                }

                c[i][j]=x;
            }
        }

        return c;

    }



    private static long[][] quickGetMi(long[][] a, long t) {

        if (a==null || a.length!=a[0].length)
            return null;

        double x=  Math.log(t)/Math.log(2);
        //1System.out.println((int)x);

        long[][][] h=Init(a,(int)x+1);

        int i=0;
        long[][] result =null;
        while (t!=0){

            long i1 = t & 1;
            if (i1!=0){
                if (result==null)
                    result=h[i];
                else
                    result=XiangCheng(result,h[i]);
            }
            t=t>>1;
            i++;
        }



        return result;
    }

    private static long[][][] Init(long[][] a, int x) {

        long[][][] g=new long[x][a.length][a[0].length];
        g[0]=a;
        for (int i = 1; i < x; i++) {
            g[i]=XiangCheng(g[i-1],g[i-1]);
        }

        return g;
    }


}
