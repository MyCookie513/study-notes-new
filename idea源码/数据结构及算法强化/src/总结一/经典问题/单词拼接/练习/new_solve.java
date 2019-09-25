package 总结一.经典问题.单词拼接.练习;

import java.util.*;


public class new_solve {


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

            //todo 判定是否具有形成欧拉路的条件；
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
            String str=DFS_new(list,start, 0 );
            if (!str.equals("***"))
               str=str.substring(0,str.length()-1);
            System.out.println(str);
        }

    }


    /**
     *
     * todo   1.    返回值：   因为DFS 中是寻找的一条线 ，而BFS中是一层层的来所以可以不用在节点中设置指针，
     *             直接在最后的递归中 可用于 嵌套返回整个路线的信息。搜索失败的话，返回一个特定的结果返回；
     *        2.   入口参数： 下一跳要满足的条件以及全局满足的条件要放在入口参数中进行传递；
     *        3.   节点的is_used ：设置代表BFS中一般都要设置避免重复遍历 ，而 DFS中：同样是避免重复遍历， 还有的是回溯的时候比较重要
     */
    private static  String  DFS_new (List<Node> li, int find_Char, int num) {
        if (num==li.size())
            return "";//todo success 代表 结束

        for (int i = 0; i < li.size(); i++) {
            Node no=li.get(i);
            if (no.str.charAt(0)== find_Char && no.used == false){
                no.used=true;
                String s=DFS_new(li,no.str.charAt(no.str.length()-1),num+1);
                if (!s.equals("***")){
                    // System.out.println(i);
                    return no.str+"."+s;
                }
                no.used=false;
            }else if (no.str.charAt(0)>find_Char){
                break;
            }
        }
        // todo  代表匹配失败
        return "***";
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
        boolean used =false;

        public Node(String str) {
            this.str = str;
        }
    }
}
