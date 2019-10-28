package Leetcode.模拟.五;

public class addStrings {

    public String addStrings(String num1, String num2) {
      StringBuilder sb=new StringBuilder("");
        char[] c1=num1.toCharArray();
        char[] c2=num2.toCharArray();
        int maxlen=Math.max(c1.length,c2.length);

        int[] a=new int[maxlen+1];

        for (int i = 0; i <maxlen ; i++) {
            int c11=c1.length-i-1;
            if (c11>=0)
                a[i]=a[i]+(c1[c11]-'0');
            int c22=c2.length-i-1;
            if (c22>=0)
                a[i]=a[i]+(c2[c22]-'0');
            if (a[i]>9) {
                a[i + 1]++;
                a[i]=a[i]%10;
            }
            sb=sb.append(a[i]);

        }

        if (a[maxlen]>0)
            sb.append(1);

        return sb.reverse().toString();

    }
}
