package 总结一.BFS.青蛙跳杯子;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {


    private static String end ;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);



        String s=sc.next();
        String e=sc.next();

        end = e;

        Map<String,Boolean> map=new HashMap<>();

        LinkedList<Node  >  lists=new LinkedList<>();

        lists.add(new Node (s,0) );
        int step =0;
        Node node =null ;

        while (!lists.isEmpty()){

            node=lists.removeFirst();
            System.out.println(node.str);
            if (node.str.equals(end))
                break;

            char[] c =node.str.toCharArray();

            for (int i=0;i<c.length;i++){
                if (c[i]=='*'){
                    int x=1;
                    int a0;
                    while (x<=3){
                        a0=i-x;
                        if (a0>=0){
                            change(c,a0,i);
                            String str=String.valueOf(c);
                            if (!map.containsKey(str)){
                                map.put(str,true);
                                lists.add(new Node(str,node.step+1));
                               // System.out.println(str);
                            }
                            change(c,a0,i);
                        }
                        a0=i+x;
                        if (a0<c.length){
                            change(c,a0,i);
                            String str=String.valueOf(c);
                            if (!map.containsKey(str)){
                                map.put(str,true);
                                lists.add(new Node(str,node.step+1));
                            }
                            change(c,a0,i);
                        }

                        x++;
                    }
                }
            }
        }

        System.out.println(node.step);

    }


    private static void change(char[] c, int j, int i) {
        char x=c[i];
        c[i]=c[j];
        c[j]=x;
    }


   static class Node {
        String str;
        int step;

       public Node(String str, int step) {
           this.str = str;
           this.step = step;
       }

   }

}
