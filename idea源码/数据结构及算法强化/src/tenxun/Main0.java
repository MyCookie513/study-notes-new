package tenxun;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Node[] nodes=new Node[num];
        for (int i=0;i<num;i++){
            int qian =sc.nextInt();
            int hou =sc.nextInt();
            nodes[i]=new Node(qian,hou,hou-qian);
        }
        //排序；
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cha-o2.cha;
            }
        });
        int result=0;
        for (int i=0;i<num;i++){
          result+=nodes[i].qian*i+nodes[i].hou*(num-i-1);
        }


        System.out.println(result);
    }
   static class Node {
        int qian ;
        int hou ;
        int cha ;

       public Node(int qian, int hou, int cha) {
           this.qian = qian;
           this.hou = hou;
           this.cha = cha;
       }
   }
}
