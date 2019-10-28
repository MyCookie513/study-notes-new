package Leetcode.模拟.六;

public class 是否是2的幂 {

    private boolean success;
    public boolean reorderedPowerOf2(int N) {
        char[] c =String.valueOf(N).toCharArray();

        //todo 求出所有的排列顺序；
        pailie(c,0);

        return success;


    }

    private void pailie(char[] c, int i) {
        if (i==c.length-1){
            if (verify(c))
                success=true;
            System.out.println(success);
            return;
        }
        char c0=c[i];

        for (int j = i; j < c.length; j++) {
           char t=c[j];
           c[j]=c0;
           c[i]=t;
           pailie(c,i+1);
           if (success)
               return;
           c[j]=t;
        }
        c[i]=c0;
    }

    private boolean verify(char[] c) {
        double x=Integer.parseInt(String.valueOf(c));


        if (x==536870912)
            System.out.println("yes");
        if (c[0]=='0')
            return false;
        //todo 这里的判定存在精度问题；
        double b=Math.log(x)/Math.log(2);
        int b1=(int)b;
        System.out.println(b+" "+b1);

        if (b1==b)
            return true;
        return false;

    }


}
