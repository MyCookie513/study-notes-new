package 百度;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in );
        int n =sc.nextInt();
        int m =sc.nextInt();


        Node[] nodes=new Node[n+1];
        for (int i = 0; i <n+1 ; i++) {
            nodes[i]=new Node();

        }


        for (int i =1;i<=m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            if (nodes[x].x==-1){
                nodes[x].x=y;
            }else{
                nodes[x].y=y;
            }
            if (nodes[y].x==-1){
                nodes[y].x=x;
            }else{
                nodes[y].y=x;
            }
        }



        Map<Integer,Boolean> a=new HashMap<>();
        Map<Integer,Boolean> b=new HashMap<>();

        for (int i = 1; i < nodes.length; i++) {
            if (a.size()<=b.size()){
                DFS(nodes,i,a,b);
            }else{
                DFS(nodes,i,b,a);
            }

        }


        int sa=a.size();
        int sb=a.size();
        int z=n-sa-sb;


        if (Math.min(sa,sb)+z>=Math.max(sa,sb))
            System.out.println((n/2)*2 );
        else{
            System.out.println((Math.min(sa,sb)+z)*2);
        }



    }

    private static void DFS(Node[] nodes,int index, Map<Integer, Boolean> x,Map<Integer, Boolean> y) {

        if (nodes[index].used==true)
            return;
        if (x.containsKey(nodes[index].x) || x.containsKey(nodes[index].y)){
            return;
        }else{
            x.put(index,false);
            nodes[index].used=true;
        }

        if (nodes[index].x!=-1){
            DFS(nodes,nodes[index].x,y,x);
            if (nodes[index].y!=-1){
                DFS(nodes,nodes[index].y,y,x);
            }
        }

    }


    static class  Node {
        int x=-1;
        int y=-1;
        boolean used =false;


    }
}
