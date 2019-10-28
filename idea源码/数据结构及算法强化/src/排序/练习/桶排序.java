package 排序.练习;

import java.util.Arrays;

public class 桶排序 {


    public static void main(String[] args) {

        int[] a={51,61,25,83,38,91,100,225,322,665,160};
        tong(a);
        System.out.println(Arrays.toString(a));
    }

    private static void tong(int[] a) {

        int[][] b=new int[10][a.length];
        int[]  h=new int[10];
        int[] t =a.clone(); //todo   a 的 副本

        int x=Integer.MIN_VALUE,index=0;

        //todo  最大值的长度
        for (int i = 0; i <a.length ; i++) {
            if (a[i]>x){
                index=i;
                x=a[i];
            }
        }
        int len=(""+a[index]).length();


        int y=0;
        for (int i = 0; i <len ; i++) {
            //todo 入桶
            for (int j = 0; j <a.length ; j++) {
                y= (int) ((a[j]/Math.pow(10,i))%10);
                b[y][h[y]]=a[j];  //todo  第 i 个数进入 y 个桶，进入桶的第 h[y] 个位置
                h[y]++;
            }

            //todo 出桶
            int m=0;
            for (int j = 0; j < 10; j++) {
                int g=0;
                while (g!=h[j]){
                    a[m]=b[j][g];
                    m++;
                    g++;
                }
                h[j]=0;
            }
            System.out.println(Arrays.toString(a));
        }

    }

}
