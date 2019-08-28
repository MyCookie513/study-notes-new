package Test;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<Integer, ArrayList<Integer>> map=new HashMap<>();

        int len=sc.nextInt();
        int[] a=new int[len];
        for (int i=0;i<len;i++){
            a[i]=sc.nextInt();
            if ( map.containsKey(a[i]))
                map.get(a[i]).add(i);
            else{
                ArrayList<Integer> list =new ArrayList<>();
                list.add(i);
                map.put(a[i],list);
            }

        }
        for (int i:map.keySet()){
            Collections.sort(map.get(i));
        }
        int cishu=sc.nextInt();int s,e,k;
        for (int i=0;i<cishu;i++){
            s=sc.nextInt();
            e=sc.nextInt();
            k=sc.nextInt();
            if (map.containsKey(k))
            query(0,map.get(k).size()-1,s-1,e-1,map.get(k));
            else {
                System.out.println(0);
            }
        }


    }

    /**
     * 在一个有序的数组中寻找在一个区间中的数有多少个
     * @param s
     * @param e
     * @param list
     */
    private static void query(int s0,int e0, int s, int e, ArrayList<Integer> list) {

        if (s0==e0){
            if (list.get(e0)>=s&&list.get(e0)<=e)
                System.out.println(1);
            else
                System.out.println(0);
            return;
        }

        int index=(s0+e0)/2;
        if (list.get(index)<s)
            query(index+1,e0,s,e,list);
        else if (list.get(index)>e)
            query(s0,index-1,s,e,list);
        else {
            int jishu=1;
            int jian=index;
            while (jian-1>=0){

                jian--;
                if (list.get(jian)>=s&&list.get(jian)<=e)
                  jishu++;
                else
                    break;
            }

            while (index+1<list.size()){

                index++;
                if (list.get(index)>=s && list.get(index)<=e)
                    jishu++;
                else
                    break;
            }

            System.out.println(jishu);
        }
    }


}
