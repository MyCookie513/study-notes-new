package 总结一.DFS;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目： 链接的一个无向图 ：最多有一个环或者没有环；
 * 求期望
 *
 * 在屏幕截图里面可以找到这个题目；
 */
public class 求期望 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num_jing=in.nextInt();
        int num_luxian=in.nextInt();
        Node[] nodes=new Node[num_jing+1];
        boolean[] b=new boolean[num_jing+1];
        for(int i=0;i<=num_jing;i++){
            nodes[i]=new Node();
        }
        for (int i=0;i<num_luxian;i++){

            int j1=in.nextInt();
            int j2=in.nextInt();
            int lu_len=in.nextInt();
            Xinxi  xinxi_j2 =new Xinxi(j2-1,lu_len);
            nodes[j1-1].list.add(xinxi_j2);
            Xinxi  xinxi_j1 =new Xinxi(j1-1,lu_len);
            nodes[j2-1].list.add(xinxi_j1);
        }

        //从每个景点的节点依次开始DFS

        List<Double> result=new ArrayList<>();
        for (int i=0;i<num_jing;i++){
            qiwang(i,nodes,result,1.0/num_jing,0);
        }
        double result0=0;
        for (Double i: result){
            result0+=i;
        }
        DecimalFormat df = new DecimalFormat( "0.00000 ");
        System.out.println(df.format(result0));

    }

    /**
     * 将要记录的数据放置在参数里：1.包括每一步要更新的数据 2.每次找到符合题意的结果 将其存储的位置；
     * DFS 深度搜索遍历： 目标是累计计算结果，直到搜索的最底部，然后回溯到上一层，继续往下尝试型使用
     *
     * 一般是寻找最佳路径，所以每次尝试的路径是不相同的，所以在使用之后要将标记去掉
     *
     * 数据结构： 定义一个数组区分每个节点，  这个节点内的结构  1。标志位： 是否已经使用过； 2.他和那些节点可以相互链接；
     *
     * @param i
     * @param nodes
     * @param result
     * @param gailu
     * @param len
     */
    private static void qiwang(int i, Node[] nodes,List<Double> result,double gailu,int len) {
        System.out.println( "yici"+i);
        nodes[i].used=true; //标记此节点已经被使用
        List<Xinxi> os=nodes[i].list;
        boolean youlu=false; //走到这个节点是否到头的标志位
        int jishu=0;
        for (int j=0;j<os.size();j++){
            if (nodes[os.get(j).mubiao].used==false){
                jishu++;
            }
        }

        for (int j=0;j<os.size();j++){
            if (nodes[os.get(j).mubiao].used==false){
                youlu=true;

                qiwang(os.get(j).mubiao,nodes,result,gailu*(1.0/jishu),len+os.get(j).len);
            }
        }
        if (youlu==false){
            System.out.println("gailu :"+gailu);
            System.out.println("len :"+len);
            result.add(gailu*len);
        }

        nodes[i].used=false;
    }


    static class Node {
       List <Xinxi> list=new ArrayList<>();
       boolean used =false;

    }

   static class Xinxi {
        int mubiao;
        int len;

       public Xinxi(int mubiao, int len) {
           this.mubiao = mubiao;
           this.len = len;
       }
   }
}

/*

4 3
1 2 3
2 3 1
3 4 4
 */