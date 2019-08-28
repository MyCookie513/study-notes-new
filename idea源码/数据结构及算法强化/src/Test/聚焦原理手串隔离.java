package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 *
 * 能够聚焦到问题的焦点
 *
 * 合理的数据的结构
 *    map可以代替数组
 *    list: 动态的数组
 *
 *
 */
public class 聚焦原理手串隔离 {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int le =sc.nextInt();
        int geli=sc.nextInt();
        int len=sc.nextInt();
        List<Integer>[] lists=new List[len+1];
        //颜色从1开始进行计数
        for (int i=1;i<=len;i++){
            lists[i]=new ArrayList<>();
        }

        //珠子的位置从0开始进行计数
        for (int i=0;i<le;i++){
            int jizhong=sc.nextInt();
            while (jizhong--!=0)
                lists[sc.nextInt()].add(i);
        }
        int jishu=0;
        //判定第一个和最后一个的位置



        for (int i=1;i<=len;i++){

            for (int j=0;j<lists[i].size();j++){
                int z=lists[i].get(j)-geli+1;
                if (z<0){
                    if (j!=0){
                        jishu++;
                        break;
                    }

                  if (lists[i].get(lists[i].size()-1)<(le+z))
                      //合法
                      continue;
                  else{
                      jishu++;
                      break;//进行下一个颜色的判定
                  }
                }else{
                    if (j-1>=0){
                      if (lists[i].get(j-1)>=z){
                          jishu++;
                          break;
                      }
                    }
                }
            }

        }


        System.out.println(jishu);




    }



}
