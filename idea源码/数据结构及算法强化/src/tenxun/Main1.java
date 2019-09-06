package tenxun;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Node[][] nodes=new Node[n+1][n+1];

        int result=Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int x=sc.nextInt();
             nodes[i][i]=new Node(x,x);
            result=Math.max(result,x*x);
        }

        //时间段的长度；
        for (int i=2;i<=n;i++){
            //每个长度的所有的时间段的情况；
            for (int j=1;j<=n-i+1;j++){

                int end =j+i-1;
                int zuidi=Math.min(nodes[j][end-1].zuidi,nodes[end][end].zuidi);
                int he =nodes[j][end-1].fenshuzhihe+nodes[end][end].fenshuzhihe;
                int pingfen=zuidi*he ;
                result=Math.max(result,pingfen);
                nodes[j][end]=new Node(zuidi,he);
            }
        }
        System.out.println(result);
    }

    static class Node {
        int zuidi ;
        int fenshuzhihe ;


        public Node(int zuidi, int fenshuzhihe) {
            this.zuidi = zuidi;
            this.fenshuzhihe = fenshuzhihe;

        }
    }
}
