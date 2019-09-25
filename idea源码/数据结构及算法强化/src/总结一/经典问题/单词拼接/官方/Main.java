package 总结一.经典问题.单词拼接.官方;
/*
 * 题意划分：入口确定，然后让你按照一定的逻辑寻找路径，直到走到出口，程序要懂得知难而退，另辟途径；
 *
 *
 * 核心算法；DFS;深度算法：内含回溯和递归算法；
 *
 * 和二叉树路径遍历不同的点
 * 二叉树是有限条可以遍历的路径
 * 而这道题是按照逻辑需求来寻找路径
 * 并且按昭逻辑寻找有可能会选择错误的入口
 * 这样情况下需要程序懂得退一步继续寻找路径
 * 如果还不行的话就需要程序再退一步；进而继续寻找；
 *
 *
 *
 * DFS：算法步骤；
 * 设置一个出口；如果走完所有的路径了，说明前面走的所有的路都是对的，依次确定返回就行
 *
 * 1.首先依次遍历路径   ，如果不符合条件返回false，证明此路不通，进入下次循环，
 * 2.如果符合条件则尝试性使用，（标记此路已经被使用，避免路径错乱），
 * 进行递归，如果返回false，证明此路最终没有走通，则需要（取消标记），进行遍历下一条路径是否符合条件并且能够走的通
 * 3.如果遍历了一遍没有找到符合条件的路，返回false，尝试性使用错误，返回上一级，进行遍历下一条路径是否符合条件并且能够走的通
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int N,len,start;
    //每一个字母的入度
    static int degree_in[]=new int[26];
    //每一个字母的出度
    static int degree_out[]=new int[26];
    //每一个字母最后排序的顺序
    static int order[]=new int[1001];
    //每一个字母是否被使用的实时情况
    static boolean used[]=new boolean[1001];
    static List<String> list;
    public static void main(String[] args) {


        Scanner scanner =new Scanner(System.in);
        N=scanner.nextInt();
        //进行每组排序后进行链接算法；
        for(int i=0;i<N;i++) {
            //进行简单的字典排序
            list=Array_str(scanner);


            //然后进行查看能否构成欧拉回路或者欧拉路；
            start=is_ola_out_start();
            System.out.println((char)('a'+start));
            if(start==-1) {  //代表不能形成欧拉路或者欧拉回路
                System.out.println("***\n");
                continue;
            }
            //返回false代表不能形成欧拉路
            if(DFS((char)('a'+start),0)==false) {
                System.out.println("***\n");
                continue;
            }

            for(int j=0;j<list.size();j++) {
                if(j==(list.size()-1))
                    System.out.print(list.get(order[j])+"\n");
                else
                    System.out.print(list.get(order[j])+".");


            }

        }



    }

    //将字符串按照字典序进行排序
    public static List<String> Array_str(Scanner scanner) {

        //N代表一共要连接几组单词；len代表每组单词的长度；start:如果为欧拉路时的节点


        len = scanner.nextInt();

        List<String> list = new ArrayList<String>();
        for(int j=0;j<len;j++){
            //这里之前用的nextLine()就不行，提示错误，看了讨论说是因为前面的nextInt没有读第一行的换行符
            String b = scanner.next();
            //将输入单词的入度和出度进行统计
            degree_out[b.charAt(0)-'a']++;
            degree_in[b.charAt(b.length()-1)-'a']++;

            list.add(b);
        }

        //将字符串进行字典排序
        Collections.sort(list);
        return list;


    }



    //根据所输入的单词的入度和出度信息来判定是否是欧拉回路或者是欧拉路，如果为欧拉路并且返回欧拉路的起点；
    //如果为欧拉路的情况此函数最终返回的是第几个字母是欧拉路的起点；
    public static int is_ola_out_start() {
        //ans用来保存欧拉路的起点
        int x1=0,x2=0,ans=0;
        //依次计算每个字母的出度和入度差；
        for(int i=0;i<26;i++) {
            //如果出度和入度差大于1，则必然不能构成欧拉回路或者欧拉路；返回-1
            if(Math.abs(degree_in[i]-degree_out[i])>1)
                return -1;

            //如果这个字母的出度比入度小一；则x1++,x1用来计算有多少个这样的字母
            if((degree_in[i]-degree_out[i])==1)
                x1++;
            //如果这个字母的出度比入度大一；则x2++,x2用来计算有多少个这样的字母，同时此时可能为欧拉路，保存欧拉路的起点；
            if((degree_in[i]-degree_out[i])==-1)
            {
                x2++;
                ans=i;//保存了欧拉路的起点
            }

        }

        //进行判定是否为欧拉回路或者欧拉路；
        //如果出现符合条件的字母大于一个的活，则必然不能形成欧拉路或者欧拉回路
        if(x1>1||x2>1) {
            return -1;
        }
        //这里因为是度数之和是双数，所以如果其中一个为零，另一个必为零；则可以形成欧拉回路
        else if(x1==0) {
            for(int i=0;i<26;i++) {
                if(degree_out[i]!=0)
                    return i;
            }
        }
        //则剩下的情况肯定是欧拉路的情况；返回欧拉路的起点；
        else  return ans;

        return -1;

    }



    //核心：先尝试性使用，如果不行则进行回溯，重新寻找满足条件的路径；
    //DFS:深度搜索；
    //   char c为要搜索的路径的进口；cnt为目前到达的路线的第几个路口
    static boolean DFS(char c,int cnt) {
        //如果有解的话，此为路线的最终出口；代表路线已经确定；
        if(cnt==len)
            return true;
        //依次遍历输入的字符串；进行尝试性排序；
        for(int i=0;i<len;i++) {

            String str=list.get(i);
            char c0=str.charAt(0);

            //单词已经进行字典序排序，如果字符比要寻找的字符小，则跳过此次循环；
            if(c0<c||used[i]) {
                continue;
            }

            //下面这种情况证明已经找不到下一个入口证明之前的尝试性使用是错误的，回溯到递归的上一级
            else if(c0>c) {
                return false;
            }

            //剩下的情况只能是已经找到入口了；
            //将此路径进行尝试性使用；
            used[i]=true;
            //标记这个单词应该出现的顺序；
            order[cnt]=i;

            //*****试探性使用，递归调用，寻找下一个寻找的目标；*******
            if(DFS(str.charAt(str.length()-1),cnt+1)) {
                return true;
            }
            //如果此时继续执行代表此时选择的路线为错误路线，需要重新进行选择；
            used[i]=false;//取消此路径已经被使用的标志；

        }


        //如果执行到此处说明找不到下一个路口，而且目标路口比所有的单词都大
        return false;
    }



}
