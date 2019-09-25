package 百度;

import 总结一.DFS.求期望;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {




    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );
        int n =sc.nextInt();
        int m =sc.nextInt();
        Node[] nodes=new Node[n+1];
        for (int i = 0; i <n+1 ; i++) {
            nodes[i]=new Node();

        }


        for (int i = 0; i <m ; i++) {
            int s =sc.nextInt();
            int e =sc.nextInt();
            int a =sc.nextInt();
            int b =sc.nextInt();


            nodes[s].list.add(new Xinxi(e,a,b));
            nodes[e].list.add(new Xinxi(s,a,b));



        }



        for (int i =0;i<=n;i++){

        }


    }


    static class Node {
        List<Xinxi> list=new ArrayList<>();
        boolean used =false;

    }

    static class Xinxi {
        int mubiao;
        int a,b;

        public Xinxi(int mubiao, int a, int b) {
            this.mubiao = mubiao;
            this.a = a;
            this.b = b;
        }
    }
}
