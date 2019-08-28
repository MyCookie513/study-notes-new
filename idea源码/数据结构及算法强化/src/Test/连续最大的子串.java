package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 连续最大的子串 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        String str=sc.next();
        char[] c=str.toCharArray();
        List<Integer>[] lists=new List[2];
        //0 -- >a   1-- >b
        lists[0]=new ArrayList<>();
        lists[0].add(-1);
        lists[1]=new ArrayList<>();
        lists[1].add(-1);
        for (int i=0;i<c.length;i++){
            if (c[i]=='a')
                lists[0].add(i);
            else
                lists[1].add(i);
        }
        lists[0].add(n);
        lists[1].add(n);

        int max=Integer.MIN_VALUE;
        // -1  2 3 5 7 9 10 11 12  15
        //处理数据
        for (int i=0;i<2;i++){
            //处理数据

            for (int j=m+1 ;j<lists[i].size();j++){
                int x=lists[i].get(j)-lists[i].get(j-(m+1));

                if (x>max)
                    max=x;
            }




        }

        System.out.println(max-1);

    }
}
