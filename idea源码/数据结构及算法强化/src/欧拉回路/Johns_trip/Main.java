package 欧拉回路.Johns_trip;


import java.util.Scanner;

/**
 *在题意中连接点不超过50个；Street :不超过2000个；
 * 1.PtoP_S[x][s]=y:代表x通过s街道可以到达y -------》使用二维数组成功实现了这个数据模型（从一个点出发有多条线路；）
 * 2.判定是否为欧拉回路条件之一：
 *             （1）每个点符合：入度==出度
 *  du[point] 记录每个点的度数；判定如果为偶数则符合要求，如果有一个单数；则不符合要求；
 *             （2）DFS测试连通性；
 *  3.used[Street]:这条街道是否被使用；
 *
 *
 */
public class Main {



     static  int[][] to=new int[50][2005];
    static  int[] du=new int[50];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean flag=true;


        int x,y=0;
        int s_max=0;
        int start;

        while (sc.hasNext()){
            x=sc.nextInt();
            y=sc.nextInt();
            if(x==0||y==0)
                break;

            for (int i=0;i<50;i++){
                for (int j=0;j<=s_max;j++){
                    to[i][j]=0;
                }
                du[i]=0;
            }
            s_max=0;


            start=Integer.MAX_VALUE;
            if(start>x)start=x;
            if(start>y) start=x;
            int s=sc.nextInt();

            if(s>s_max) s_max=s;
            to[x][s]=y;to[y][s]=x; /*将节点之间的联通情况记录*/
            du[x]++;du[y]++;/*记录每一个point的度*/
            while (sc.hasNext()  ){
                x=sc.nextInt();
                y=sc.nextInt();
                if(x==0||y==0)
                    break;
                s=sc.nextInt();
                if(start>x)start=x;
                if(y<start) start=x;
                if(s>s_max) s_max=s;
                to[x][s]=y;to[y][s]=x; /*将节点之间的联通情况记录*/
                du[x]++;du[y]++;/*记录每一个point的度*/

            }

            for(int i=0;i<50;i++){

                if (du[i]%2!=0){
                    flag=false;/*肯定不能构成欧拉回路*/
                    break;
                }
            }



            if(flag==false)
                System.out.println("Round trip does not exist.");
            else{
                boolean[] used=new boolean[s_max+1];
                String str=DFS(start,0,s_max,used,to);

                if(str!=null)
                    System.out.println(str.trim());
                else
                    System.out.println("Round trip does not exist.");
            }

        }

    }




    /*如果最终结果不通则会回溯到上一层，然后再尝试选择其他路线；如果最终结果相通则一层一层递归返回*/
    static String DFS(int start,int jishu,int streets,boolean[] used,int[][] to){

        for (int i=1;i<=streets;i++){
            if(used[i]==false&&to[start][i]!=0){
                used[i]=true;

                String str=DFS(to[start][i],jishu+1,streets,used,to);
                if(str==null) {
                    used[i] = false;
                    continue;
                }else{
                        return i+" "+str;
                }
            }

        }

        /*再面对路走到尽头的时候，返回为true or false  */
        if(jishu==streets){
            return "";
        }else
            return null;




    }





}




