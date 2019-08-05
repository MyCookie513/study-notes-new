package ClassLoader;


import java.util.Date;

public class Test extends Date {


    static {
        p=10;
    }
    private static int p=9;

    @org.junit.Test
    public void test(){

        int[] a=new int[10];
        System.out.println(a[0]);

        df();



    }

    @org.junit.Test
    public void Tse(){
        System.out.println(Test.p);
    }

    public void df(){
        System.out.println();
    }

}
