package 总结一.经典问题.单词拼接.练习;

import java.util.*;

/**
 * 2
 * 6
 * aloha
 * arachnid
 * dog
 * gopher
 * rat
 * tiger
 * 3
 * oak
 * maple
 * elm
 */
public class Main {


    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int x=sc.nextInt();


        for (int i = 0; i <x ; i++) {

            // 0 :  ru du
            int[][] a=new int[128][2];

            List<Node> list =new ArrayList<Node>();

            int num =sc.nextInt();
            for (int j = 0; j <num ; j++) {
                String str=sc.next();
                list.add(new Node(str));
                char head = str.charAt(0);
                a[head][0]++;

                char end = str.charAt(str.length()-1);
                a[end][1]++;
            }

            //todo
            int start =is_oulalu(a);
            if (start == -1 ){
                System.out.println("***");
                continue;
            }
           // System.out.println((char)start);

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.str.charAt(0)-o2.str.charAt(0);
                }
            });

            //todo
           int b= DFS(list,start, 0 );

           if (b==-1){
               System.out.println("***");
           }else{
               StringBuilder builder=new StringBuilder("");
               int y=b;
               while (y!=-2){
                  // System.out.println("dd"+y);
                   builder.append(list.get(y).str+'.');
                   y=list.get(y).index;

               }
               System.out.println(builder.substring(0,builder.length()-1));
           }
        }

    }

    private static  int  DFS(List<Node> li, int start, int num) {

        if (num==li.size())
            return -2;//todo -2 代表 结束

        for (int i = 0; i < li.size(); i++) {
            Node no=li.get(i);
            if (no.str.charAt(0)== start && no.used == false){
                no.used=true;
                int h=DFS(li,no.str.charAt(no.str.length()-1),num+1);
                if (h!=-1){
                   // System.out.println(i);
                    no.index=h;
                    return i;
                }
                no.used=false;
            }else if (no.str.charAt(0)>start){
                break;
            }

        }

        // todo  代表匹配失败
        return -1;


    }


    private static int is_oulalu(int[][] a) {

        boolean is_start =false;
        boolean is_end =false;
        int s=0;

        for (int i = 0; i < a.length; i++) {
            if (a[i][0]-a[i][1] <0){ //start
                if (is_start==true)
                   return -1;
                else {
                    is_start = true;

                }
            }else if (a[i][0]-a[i][1] >0){//end
                if (is_end==true)
                    return -1;
                else {
                    is_end = true;
                    s=i;
                }
            }
        }
        return s;
    }

    static class Node {
        String str;
        int index=-2;
        boolean used =false;

        public Node(String str) {
            this.str = str;
        }
    }
}
