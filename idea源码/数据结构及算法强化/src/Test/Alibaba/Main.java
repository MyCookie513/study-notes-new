package Test.Alibaba;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }
    private static int getMinimumTimeCost(int n, int[][] area) {

       Obj ob=new Obj();
        for(int i=0;i<area.length;i++){

            xxx(area,0,i,0,ob);
        }
        int t=ob.min;
        return t;
    }
   static class Obj{
        int min=Integer.MAX_VALUE;
    }

    private static void xxx(int[][] a,int x,int y,int hadtime,Obj obj) {


        if (x==a.length-1){
            if (hadtime<obj.min)
                obj.min=hadtime;

        }else if (x==a.length-1-1){
            if (hadtime+a[x+1][y]<obj.min)
                obj.min=hadtime+a[x+1][y];

        }else {
            //向下走
            xxx(a,x+2,y,hadtime+a[x+1][y],obj);
        }

        if (y==a.length-1 || y==a.length-2) {

        }else  xxx(a, x, y + 2, hadtime + a[x][y + 1], obj);
    }
}
