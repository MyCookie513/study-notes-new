package Test;

import java.util.*;

public class 字符串开心消消乐 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int x=sc.nextInt();
        solve0(str,x);

    }

    /**
     * 1.找出每个字符的存在的位置关系
     * 2.想办法进行条件判定
     * @param s
     * @param m
     */
    private static void solve(String s, int m) {
        Map<Character, List> map = new HashMap<>(26);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            List list = map.get(c);
            if (list == null)
                map.put(c, list = new ArrayList<Integer>(100));
            list.add(i);
        }
        int maxLen = 1;
        for (Map.Entry<Character, List> entry : map.entrySet()){
            List<Integer> arrayList = entry.getValue();
            for (int i = 0; i < arrayList.size(); i++){
                int ctr = arrayList.get(i);
                int []move = new int[arrayList.size()];
                // 获取 move[]，表示每个相同字母到中心点 ctr 需要移动的最少步数
                for (int j = 0; j < arrayList.size(); j++)
                    move[j] = (Math.abs(arrayList.get(j) - ctr) -
                            Math.abs(i - j));
                // 排序后，选择移动代价最少的前 k + 1 个
                Arrays.sort(move);
                int sum = 0;
                for (int k = 0; k < move.length; k++){
                    sum += move[k];
                    if (sum > m)
                        break;
                    if (k + 1 > maxLen)
                        maxLen = k + 1;
                }
            }
        }
        System.out.println(maxLen);

    }


    private static void solve0(String  str,int m){
        Map<Character,List<Integer>> map=new HashMap<>();
        char[] c=str.toCharArray();

        for (int i=0;i<c.length;i++){
            if (map.containsKey(c[i]))
                map.get(c[i]).add(i);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(c[i],list);
            }
        }




        int max=Integer.MIN_VALUE;
        //针对每一个字符出现的位置进行分析，聚合m步后，最多能聚合多少个

        for (Map.Entry<Character,List<Integer>> entry: map.entrySet()){
            List<Integer> list=entry.getValue();

            //尝试不同的中心点
            for (int i=0;i<list.size();i++){
                int t=0;
                List<Integer> lt=new ArrayList<>();
               for (int j=0;j<list.size();j++){
                    int step=Math.abs(list.get(i)-list.get(j))-1-(Math.abs(i-j)-1);
                    lt.add(step);
                }
               Collections.sort(lt);
               int y=0,n=m;
               while (y<lt.size()&&n>=0){
                   n=n-lt.get(y);
                   if (n>=0)
                       t++;
                   y++;
               }
               if (t>max)
                   max=t;
            }

        }


        System.out.println(max);



    }




}
