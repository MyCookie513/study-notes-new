package Test;

import java.util.*;

public class main1 {


    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Map<Integer,Integer> re=new HashMap<>();

        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int queue=sc.nextInt();
        int yanse =sc.nextInt();


        Node  nd=new Node(null);
        Node head=nd;
        for (int i=0;i<len;i++){
            int chang=sc.nextInt();
            int[] a=new int[chang];
            for (int j=0;j<chang;j++){
                a[j]=sc.nextInt();
            }

            Node node =new Node(a);
            nd.next=node;
            nd=node;
        }

        nd.next=head.next;

        Node head0=nd;
        Node node =nd;
        LinkedList<Node>  que=new LinkedList<>();
        for (int i=0;i<queue;i++){
            que.addLast(node);
            for (int x=0;x<node.a.length;x++){
                if (map.containsKey(node.a[x])) {
                    map.put(node.a[x],map.get(node.a[x])+1);
                    re.put(node.a[x],0);
                }else map.put(node.a[x],1);
            }
            node =node.next;
        }



        while (len!=0){
            len--;
            Node last=que.removeFirst();
            for (int x=0;x<last.a.length;x++){
                if (map.get(last.a[x])==1)
                    map.remove(last.a[x]);
                else
                   map.put(last.a[x],map.get(last.a[x])-1);
            }
            que.addLast(node);
            for (int x=0;x<node.a.length;x++){
                if (map.containsKey(node.a[x])) {
                    map.put(node.a[x],map.get(node.a[x])+1);
                    re.put(node.a[x],0);
                }else map.put(node.a[x],1);
            }
            node =node.next;
        }
        System.out.println(re.size());


    }
}

class Node {
     int[] a;
    Node  next;

    public Node(int[] a) {
        this.a = a;
    }
}