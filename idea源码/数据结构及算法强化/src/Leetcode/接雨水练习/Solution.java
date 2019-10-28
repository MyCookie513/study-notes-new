package Leetcode.接雨水练习;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {


    public int trap(int[] height) {
        if (height==null || height.length==0 )
            return 0;
        int[] a=height.clone();

        Node[] nodes=new Node[height.length];
        for (int i = 0; i <height.length ; i++) {
            nodes[i]=new Node(height[i],i);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value-o1.value;
            }
        });

        Node x=nodes[0];int result=0;
        int l=x.index,r=x.index;
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].index <l){
                for (int j = nodes[i].index+1; j< l; j++) {
                 result=  result+ nodes[i].value-a[j] ;
                }
                l=nodes[i].index;
            }else if (nodes[i].index>r){
                for (int j = r+1; j< nodes[i].index; j++) {
                    result=  result+ nodes[i].value-a[j] ;
                }
                r=nodes[i].index;
            }
        }


        return result;


    }



    class Node {
        int value;
        int index;
        boolean used =false;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }


}
