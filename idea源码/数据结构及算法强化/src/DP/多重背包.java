package DP;

import java.util.Scanner;

public class 多重背包 {


    public static void main(String[] args) {
        int[][] a;//0:valumn 1:value
        int max;//*背包的容量*//*
        int n;//*一共几组数据*//*
        int num;//*物品的数量；*//*

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        while (n--!=0){
            num=sc.nextInt();
            a=new int[num][3];

            max=sc.nextInt();
            //*得到每个物品的价值*//*
            for (int i=0;i<num;i++){
                a[i][1]=sc.nextInt();
            }
            for(int i=0;i<num;i++){
                a[i][0]=sc.nextInt();
            }
            for(int i=0;i<num;i++){
                a[i][2]=sc.nextInt();
            }
            int result= DP3(a,max);//**//*
            System.out.println(result);

        }
    }

    private static int DP3(int[][] a, int max) {
        int[] T =new int[max+1];/*代表每个小模块*/

        for(int i=0;i<a.length;i++){/*对面对的新的条件进行遍历*/
            for(int y=1;y<=a[i][2];y++) {
                for (int j = max; j >=y* a[i][0]; j--) {/*先对合模块进行Dynamic 选择(因为合模块是由分模块拼凑出来的)，然后再 对分模块进行Dynamic选择；*/
                    T[j] = Math.max(y*a[i][1] + T[j - y*a[i][0]], T[j]);
                }
            }
        }
        return T[max];
    }

}
