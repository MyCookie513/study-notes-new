package 总结一.BFS.倒数容器问题;


import java.util.*;
import java.util.stream.Collectors;

public class BFS_三个容器 {



    public static void main(String[] args) {
        int[] a=new int[3];
        Scanner sc =new Scanner(System.in);
        for (int i =0;i<a.length;i++){
            a[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        Map<String,Boolean> map =new HashMap();
        LinkedList<Node> lists=new LinkedList<>();
        Node node=null;
        int[] k={0,0,0};
        String s=Arrays.stream(k).boxed().map(p -> p.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
                .collect(Collectors.joining(" "));
        map.put(s,true);
        lists.addLast(new Node(k,0));
        while (!lists.isEmpty()){
            boolean b=false;
            node =lists.removeFirst();
            for (int i=0;i<node.v.length;i++){
                if (node.v[i]==target) {
                    b = true;
                    break;
                }
            }
            if (b==true){
                break;
            }


            //1. 尝试加满一个容器
            for (int i=0;i<node.v.length;i++){
                if (node.v[i]!=a[i]) {
                    int[] x=Arrays.copyOf(node.v,3);
                    x[i]=a[i];
                    solve(lists,map,x,node);
                }
            }


            //2. 尝试将容器中的水清零
            for (int i=0;i<node.v.length;i++){
                if (node.v[i]!=0) {
                    int[] x=Arrays.copyOf(node.v,3);
                    x[i]=0;
                    solve(lists,map,x,node);
                }
            }

            //3. 将容器中的水导入另一个容器；
            for (int i=0;i<node.v.length;i++) {

                for (int j=0;j<node.v.length;j++) {

                    if ( node.v[i]!=0 && i!=j){

                        //从i导入 j;
                        int[] x=Arrays.copyOf(node.v,3);
                        int t=(a[j]-x[j]);
                        if (x[i]>t){
                            x[i]=x[i]-t;
                            x[j]=a[j];
                            solve(lists,map,x,node);
                        }else {
                            x[j]=x[j]+x[i];
                            x[i]=0;
                            solve(lists,map,x,node);
                        }
                    }
                }
            }


        }

        System.out.println(node.step);

    }


    static void solve(LinkedList<Node> list,Map<String,Boolean> map,int[] a,Node node){
        String str1 = Arrays.stream(a).boxed().map(p -> p.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
                .collect(Collectors.joining(" "));
        if (!map.containsKey(str1)){
            map.put(str1,true);
            list.addLast(new Node(a,node.step+1));
        }

    }


    static class Node {
        int[] v ;
        int step ;

        public Node(int[] v, int step) {
            this.v = v;
            this.step = step;
        }
    }
}
