package 百度;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );
        int T =sc.nextInt();
        for (int i = 0; i < T; i++) {

            int n =sc.nextInt();
            int m =sc.nextInt();
            Node[] nodes =new Node[n+1];
            for (int j = 0; j < n+1; j++) {
                nodes[j]=new Node(j);
            }

            for (int j = 0; j <m ; j++) {
                int x =sc.nextInt();
                int y =sc.nextInt();

                nodes[x].list.add(y);
                nodes[y].list.add(x);
            }
            LinkedList<Node  > lists=new LinkedList<>();
            nodes[1].step=0;
            nodes[1].used=true;
            lists.add(nodes[1]);
            Node node;

            boolean b=false;
            while (!lists.isEmpty()){

                node=lists.removeFirst();
                int step =node.step;

                if (node.value==n)
                {
                    b=true;
                    break;
                }
                for (int h: node.list){

                    if (step !=2 && nodes[h].used==false){
                        nodes[h].step=step+1;
                        nodes[h].used=true;
                        lists.addLast(nodes[h]);
                    }
                }


            }
            if (b==true)
                System.out.println("POSSIBLE");
            else
                System.out.println("IMPOSSIBLE");

        }





    }

    static class Node {
        List<Integer> list=new LinkedList<>();
        int step;
        int value;
        boolean used =false;

        public Node(int value) {
            this.value = value;
        }
    }

}
