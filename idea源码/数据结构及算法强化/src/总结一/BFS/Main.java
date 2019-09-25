package 总结一.BFS;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    //下，右，左，上；字典序的四个方向；
    private static int[][] a={{1,0},{0,1},{0,-1},{-1,0}};
    private static char[] c0={'D','R','L','U'};
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );

        int n =sc.nextInt();
        int m =sc.nextInt();
        char[][] c =new char[n][m];
        for (int i =0;i<n;i++){
            c[i]=sc.next().toCharArray();
        }


        //从 0，0 到 n-1，m-1
        LinkedList<Node> list =new LinkedList<>();

        list.add(new Node(0,0,null,'\n'));
        c[0][0]='1';
        Node node = null;
        while (!list.isEmpty()){
            node=list.removeFirst();


            //System.out.println( node.next_x +"/"+node.next_y +"/"+node.str);
            if (node.next_x == n-1 && node.next_y== m-1){
                break;
            }

            //尝试找到下一个节点；
            for (int i=0;i<4;i++){

                int x= node.next_x+a[i][0];
                int y= node.next_y+a[i][1];
                //说明下一个节点是合法的；
                if ( x>=0 && y>=0 && x<n  && y<m  && c[x][y]=='0'){
                    c[x][y]='1';
                    list.addLast(new Node(x,y,node,c0[i]));
                }

            }

        }



        StringBuilder sb=new StringBuilder();
        while (node.parent!=null){
            sb.insert(0,node.c);
            node=node.parent;

        }

        System.out.println(sb.length()+"\n"+sb.toString());

    }


    /**
     * 记录下一个要遍历的节点；
     *
     */
    static class Node {

        //路线的记录
        Node parent;

        //下一个要遍历的节点；
        int next_x ;
        int next_y;

        //每一步的方向
        char c;

        public Node( int next_x, int next_y, Node parent ,char c) {
            this.next_x = next_x;
            this.next_y = next_y;
            this.parent = parent;
            this.c=c;
        }
    }
}
