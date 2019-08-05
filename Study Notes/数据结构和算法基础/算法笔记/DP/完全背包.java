package DP;

import java.util.Scanner;

/**
 *
 *完全背包问题描述：有编号分别为a,b,c,d的四件物品，它们的重量分别是2,3,4,7，它们的价值分别是1,3,5,9，
 * 每件物品数量无限个，现在给你个承重为10的背包，如何让背包里装入的物品具有最大的价值总和？
 *
 *
 */
public class 完全背包 {


    public static void main(String[] args) {
        int[][] a;//0:valumn 1:value
        int max;//*背包的容量*//*
        int n;//*一共几组数据*//*
        int num;//*物品的数量；*//*

        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        while (n--!=0){

            num=sc.nextInt();
            a=new int[num][2];
            max=sc.nextInt();
            //*得到每个物品的价值*//*
            for(int i=0;i<num;i++){
                a[i][1]=sc.nextInt();
            }


            for(int i=0;i<num;i++){
                a[i][0]=sc.nextInt();
            }
            int result= DP2(a,max);//**//*
            System.out.println(result);

        }
    }

    private static int DP2(int[][] a, int max) {
        int[] T =new int[max+1];/*代表每个小模块*/
        for(int i=0;i<a.length;i++){/*对面对的新的条件进行遍历*/
            for(int j=a[i][0];j<=max;j++){/*先对合模块进行Dynamic 选择(因为合模块是由分模块拼凑出来的)，然后再 对分模块进行Dynamic选择；*/
                T[j]= Math.max(a[i][1]+T[j-a[i][0]],T[j]);
            }
        }
        return T[max];
    }



}





