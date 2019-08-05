package 拷贝;

import java.util.ArrayList;
import java.util.List;

public class list深层copy {


    public static void main(String[] args) {
        List<Node> fin_Ls;

        List<Node> list =new ArrayList<Node>();

        list.add(new Node(0,0));
        list.add(new Node(1,1));

        fin_Ls=new ArrayList<>(list);

        System.out.println(fin_Ls.toString());
        list.set(0,new Node(-1,-1));

        System.out.println(fin_Ls.toString());
    }

   static class Node {
        int a;
        int b;
       @Override
       public String toString() {
           return "Node{" +
                   "a=" + a +
                   ", b=" + b +
                   '}';
       }

       public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }


    }
}
