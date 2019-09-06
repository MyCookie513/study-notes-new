package 字节跳动;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.*;

public class 世界杯开幕式 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int M =sc.nextInt();

       List<Node> list= new ArrayList<>();

        for (int i=0;i<M ;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            boolean b=false;
            boolean shixiao=false;
            for (int j=0;j<list.size();){
                Node node=list.get(j);
                if (x>node.x && y>node.y){
                    if (b==true){
                        list.remove(node);
                        continue;
                    }
                    node.x=x;
                    node.y=y;
                    b=true;
                } else if (x<=node.x && y<=node.y){
                    shixiao =true;
                    break;
                }
                j++;
            }


            //这个元素没有被替换。并且也没有失效；
            if (b == false && shixiao==false){
                list.add(new Node(x,y));
            }
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x-o2.x;
            }
        });

        for (int i=0;i<list.size();i++){
            Node node =list.get(i);
            System.out.println(node.x+" "+node.y);
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
