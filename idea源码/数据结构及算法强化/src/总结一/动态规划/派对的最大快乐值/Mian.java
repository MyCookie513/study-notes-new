package 总结一.动态规划.派对的最大快乐值;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/***
 * 题目链接： https://www.nowcoder.com/practice/a5f542742fe24181b28f7d5b82e2e49a
 */
public class Mian {


    public static void main(String[] args) {


        Scanner sc =new Scanner(System.in);
        int num =sc.nextInt();

        int boss =sc.nextInt();

        Node[] nodes =new Node[num+1];
        for (int i=1;i<=num;i++){
            int happer=sc.nextInt();
            nodes[i]=new Node(happer);
        }
        for (int i=1;i<num;i++){
            int u=sc.nextInt();
            int d=sc.nextInt();
            nodes[u].list.add(d);
        }




        last_read(nodes[boss],nodes);


        System.out.println(Math.max(nodes[boss].x,nodes[boss].y));


    }
    private static void last_read(Node node,Node[] nodes) {

        node.y+=node.happy;
        //先进行遍历子节点
        for (int i: node.list){
            last_read(nodes[i],nodes);
            node.x+=Math.max(nodes[i].x,nodes[i].y);
            node.y+=nodes[i].x;
        }

    }


    static class Node {
        int happy ;
        List<Integer> list=new ArrayList<>();
        int x=0;
        int y=0;
        public Node(int happy) {
            this.happy = happy;
        }
    }
}
