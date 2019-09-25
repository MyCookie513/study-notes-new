package 总结一.动态规划.合并石子之动态规划__keneng;

import java.util.Scanner;

public class Retry0 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int[] a=new int[num+1];
        int[][] re=new int[num][num];


        for (int i=1;i<=num;i++){
            a[i]=sc.nextInt()+a[i-1];
        }
        if (a.length==2){
            System.out.println(a[1]);
            return;
        }

        //合并堆的长度,堆数从0开始；
        for (int i=2;i<=num;i++){
            for (int j=0;j<=num-i;j++){
                int y=j+i-1;
                int fen_ge =j;
                int min=Integer.MAX_VALUE;
                while (fen_ge<y){
                    int h=re[j][fen_ge]+re[fen_ge+1][y] +a[y+1]-a[j];
                    if (h<min)
                        min=h;
                    fen_ge++;
                }
                re[j][y]=min;
               // System.out.println("j: "+j + " y:"+y +"  re[j][y] :" +  re[j][y] +" a[y+1]: "+a[y+1]+"a[j] :"+a[j]);

            }
        }

        System.out.println(re[0][num-1]);

    }
}
