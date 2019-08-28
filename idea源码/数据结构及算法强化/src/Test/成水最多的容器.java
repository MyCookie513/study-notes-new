package Test;

import java.util.Arrays;
import java.util.Comparator;

/***
 * 双指针法要快很多
 */
public class 成水最多的容器 {


    public static void main(String[] args) {
        int[] a={3,16,15,30,1,16};
        System.out.println(maxArea(a));
    }

    public static int maxArea0(int[] height) {
        if (height.length<=1)
            return 0;
        if (height.length==2)
            return Math.min(height[0],height[1]);

        Node[] n=new Node[height.length];
        for (int i=0;i<height.length;i++){
            n[i]=new Node();
            n[i].xulie=i;
            n[i].zhi=height[i];
        }

        Arrays.sort(n, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return -o1.zhi+o2.zhi;
            }
        });
       /* for (int i=0;i<height.length;i++){
            System.out.println(n[i].zhi);
        }*/



        Node L,R;
        if (n[0].xulie<n[1].xulie){
            L=n[0];
            R=n[1];
        }else{
            R=n[0];
            L=n[1];
        }

        int max=(R.xulie-L.xulie) * Math.min(n[0].zhi,n[1].zhi);
        for (int i=2;i<height.length;i++){
            if (n[i].xulie>R.xulie){
                R = n[i];
                int s=(n[i].xulie-L.xulie)*Math.min(n[i].zhi,L.zhi);
                if (s>max) {
                    max=s;
                }
            }
            if (n[i].xulie<L.xulie){
                L = n[i];
                int s=(R.xulie-n[i].xulie)*Math.min(n[i].zhi,R.zhi);
                if (s>max) {
                    max=s;
                }
            }
        }
        return max;


    }

    static class Node{
        int xulie;
        int zhi;
    }

    public static int maxArea(int[] height) {
        int s=0,e=height.length-1;
        int max=0;
        while (s<e){
            int s0=Math.min(height[s],height[e])*(e-s);
            max=Math.max(s0,max);
            if (height[s]<height[e]){
                s++;
            }else if (height[s]==height[e]){
                s++;
                e--;
            }else{
                e--;
            }
        }
        return max;

    }

}
