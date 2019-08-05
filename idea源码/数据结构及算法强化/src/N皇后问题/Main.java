package N皇后问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<List<String>> fin=  solveNQueens(5);
        System.out.println(fin.toString());

    }




    public static List<List<String>> solveNQueens(int n) {

        //使用数组记录这个点的不合法程度和是否被占领  -1：被占领   0：允许放置  1..：不合法程度依次升高
        int[][] a=new int[n][n];


        //初始化这个数据，初始为  ：  .
        List<List<String >> fin_Ls=new ArrayList<>();


        /*初始化一个方格塔*/
        List<String> list =new ArrayList<>();
        StringBuffer stringBuffer=new StringBuffer();
        for (int j=0;j<n;j++){
            stringBuffer.append('.');
        }
        for (int i=0;i<n;i++){
            list.add(stringBuffer.toString());
        }



        //进行深搜+回溯；

        DFS(a,n,0,fin_Ls,list);



        return fin_Ls;
    }

    /**
     *
     * @param a ：在数组中更新新添加的节点的影响；
     * @param x ：x y为新添加的位置的坐标；
     * @param y
     * @param n :边界的设定
     */

    static void flag_xie(int[][] a,int x,int y,int n,int flag){

        int[][] h={{1,1},{-1,-1},{-1,1},{1,-1}};

        for(int i=0;i<4;i++){
            int x0=x+h[i][0],y0=y+h[i][1];
            //对这个方向进行侵染看是否越界
            while(x0>=0&&x0<n&&y0>=0&&y0<n){

                a[x0][y0]+=flag;

                x0+=h[i][0];
                y0+=h[i][1];

            }
        }
    }

    /**
     * 竖线侵染
     */
    static  void shu_xiang(int[][] a,int x,int y,int n,int flag){

        int y0=y+1;
        while(y0>=0&&y0<n){
            a[x][y0]+=flag;
            y0+=1;
        }

        y0=y-1;
        while(y0>=0&&y0<n){
            a[x][y0]+=flag;
            y0-=1;
        }


    }

    /**
     *
     * @param a：对塔的限定数组
     * @param n：方格塔的大小
     * @param h：一层一层的攀爬到达的层数
     */

    static  boolean  DFS(int[][] a,int n,int h,List<List<String>> fin_Ls,List<String> list){


        if(h==n){
            fin_Ls.add(new ArrayList<>(list));
            return false;
        }

        /*如果找到最后一层有节点可以占领，则将节点添加到总输出结果*/



        for(int i=0;i<n;i++){
            /*如果在这一层寻找到可用位置则递归对下一层寻找*/
            if(a[i][h]==0){
                /*确定占领位置要两个操作，数组和list，*/
                a[i][h]=-1;
                flag_xie(a,i,h,n,1);
                shu_xiang(a,i,h,n,1);

                StringBuffer stringBuffer= new StringBuffer(list.get(h));
                stringBuffer.replace(i,i+1,"Q");
                list.set(h,stringBuffer.toString());

                /*尝试递归进行下一次的操作,*/
                if(DFS(a, n, h+1, fin_Ls, list)){

                }else {
                    /*进行撤销操作数组和list*/
                    a[i][h]=0;
                    flag_xie(a,i,h,n,-1);
                    shu_xiang(a,i,h,n,-1);

                    StringBuffer stringBuffer0= new StringBuffer(list.get(h));
                    stringBuffer0.replace(i,i+1,".");
                    list.set(h,stringBuffer0.toString());
                    continue;
                }




            }else{
                /*如果找不到可占领的位置，接着遍历横向的下一个节点*/
               continue;
            }

        }

        /*遍历完整个横向之后，回溯到上一层*/
        return false;


    }









}
