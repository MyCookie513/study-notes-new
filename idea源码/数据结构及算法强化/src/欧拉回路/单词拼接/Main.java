package 欧拉回路.单词拼接;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        while ((N--)!=0){
            int n=scanner.nextInt();
            List<String> list=new ArrayList<>();
            for (int i=0;i<n;i++){
                list.add(scanner.next());
            }

            /*将字符串按照字典序排序*/

            Collections.sort(list);
            boolean[] used=new boolean[list.size()];
            int[][] a=oi_num(list);
            int x=Is_ola(a);
            if (x>0)
            System.out.println(DFS(used,list,(char)(Is_ola(a)-1+'a'),0));
            else System.out.println(x);
        }





    }


    /**
     * 统计所有点的出度和入度；
     */

    static  int[][] oi_num(List<String> list){

        int[][] a=new int[26][2];
        for (int i=0;i<list.size();i++){
            String s=list.get(i);
            /*记录每个字母point 的出度*/
            a[s.charAt(0)-'a'][0]++;
            /*记录每个字母点的入度*/
            a[s.charAt(s.length()-1)-'a'][1]++;

        }
        return a;
    }


    /**
     * 根据point的出度和入度判定是否为欧拉回路或者欧拉路
     * 返回：-1：不能形成欧拉回路或者欧拉路
     * 返回：0：能够形成欧拉回路；
     * 返回：>=1:能够形成欧拉路；且返回flag+1；
     */

    static  int  Is_ola(int[][] a){
        int start = 0;
        int chu=0,ru=0;
        for(int i=0;i<26;i++){

            if(a[i][0]==a[i][1]){

            }else if (a[i][0]-a[i][1]==1){
                start=i;
                chu++;
            }else if (a[i][1]-a[i][0]==1){
                ru++;
            }else return -1;
        }

        /*如果只有一个起点和终点*/
        if(chu==ru&&ru==1){
            return start+1;
        }else return 0;

    }


    /**
     * 利用DFS判断欧拉路的连通性
     * 尝试使用 一个出度；看最终是否联通所有point
     * 如果不符合回溯到上一步，尝试使用下一个出度；
     * num:从零开始，寻找第几个
     *
     *
     *
     *
     *
     *
     *
     */

    static String  DFS(boolean[] used,List<String> list,char start,int num){




        for (int i=0;i<list.size();i++){
            String ss=list.get(i);
            /*如果符合条件，尝试性使用，并进行递归下一步*/
            if(used[i]==false && ss.startsWith(String.valueOf(start))){
                /*尝试使用*/
                used[i]=true;
                /*如果递归结果最后成功，则使用，如果失败则清除痕迹继续遍历*/
                String str=DFS(used,list,ss.charAt(ss.length()-1),num+1);
                if(str!=null)
                    return ss+"."+str;
                else{
                    used[i]=false;
                    continue;
                }

            }else {
                if(ss.charAt(0)>start)
                    break;
            }
        }

        /*最后遍历所有都找不到出度，1.已经使用完所有的String；2.中间跨过了一个欧拉回路导致没有全部联通*/
        if(num==list.size())
            return "";
        else
            return null;



    }











}





