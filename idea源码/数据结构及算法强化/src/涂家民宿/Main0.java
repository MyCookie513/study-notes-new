package 涂家民宿;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main0 {


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N_city=sc.nextInt();
        int M_lu =sc.nextInt();
        int xuzhao=sc.nextInt();
        int[] a=new int[xuzhao];
        Node[] nodes=new Node[N_city];
        for (int i=0;i<xuzhao;i++){
            a[i]=sc.nextInt();
        }

        for (int i=0;i<N_city;i++){
            nodes[i]=new Node();
        }
        for (int i=0;i<M_lu;i++){
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            int juli =sc.nextInt();

            nodes[a1].list.add(new lianjie(a2,juli));
            nodes[a2].list.add(new lianjie(a1,juli));

        }



        for (int i=0;i<xuzhao;i++){
          int s=BFS (a[i],nodes);
        }





    }

    private static int BFS(int i, Node[] nodes) {

        LinkedList<lianjie> linkedList=new LinkedList<>();
        List<lianjie> li=nodes[i].list;
        for (int h=0;h<li.size();h++){
            linkedList.addLast(li.get(h));
        }

        while (!linkedList.isEmpty()){

            lianjie lj=linkedList.removeFirst();
            List<lianjie> lif=nodes[lj.next].list;
            for (int h=0;h<lif.size();h++){
                linkedList.addLast(new lianjie(lif.get(h).next,lj.juli+lif.get(h).juli));
            }
        }

        return 0;




    }


    static class Node {
        int id;
        List<lianjie > list =new ArrayList<>();
    }
   static class lianjie {
        int next;
        int juli ;

        public lianjie(int next, int juli) {
            this.next = next;
            this.juli = juli;
        }
    }

}
