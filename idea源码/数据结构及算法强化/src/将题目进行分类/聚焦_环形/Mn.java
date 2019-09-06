package 将题目进行分类.聚焦_环形;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mn {


    /**
     * 最幸福的男生： 旁边女生最多的男生；
     * 选取一段连续的序列其中包括k个女生，条件是有 最多的男生数量；
     *
     * @param args gbgg b gg bbgbbgbgbb g
     *             gbggbggbbgbbgbgbbg
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        int x = in.nextInt();
        getIndexAndLongest(_users.toCharArray(), x);

    }

    static void getIndexAndLongest(char[] c, int k) {

        List<Integer> boy = new ArrayList<>();
        List<Integer> girl = new ArrayList<>();


        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'g') {
                girl.add(i);
            } else
                boy.add(i);
        }

        //求最幸福的男生
        int max_girl=0,index=0;
        for (int i=0;i<boy.size();i++){
            int num_girl=0;
            if (i-1>=0 && i+1<boy.size()){
                num_girl=boy.get(i+1)-boy.get(i-1)-2;
            }else if (i-1<0){
                num_girl=boy.get(1)-1;
                num_girl+=c.length-1-boy.get(boy.size()-1);
               // System.out.println(i + ":" + num_girl);
            }else if (i+1==boy.size()){
                num_girl=c.length-1-boy.get(i-1)-1+boy.get(0);
            }
            if (num_girl>max_girl){
                index=i;
                max_girl=num_girl;
            }
        }
       // System.out.println(index);

        //k个女生最多男生的数量；
        k+=2;
        int max_num_boy=0;
        for (int i=0;i<girl.size();i++){
            int num_boy=0;
            if (i+k-1<girl.size()) {
                int en_index = i + k - 1;
                num_boy = girl.get(en_index) - girl.get(i) - k + 1;
                System.out.println(num_boy);
            }else{

                int index_s=i+k-2-(girl.size()-1);
                int ss=girl.get(index_s)+1;
               // System.out.println("ss"+ss);
                int ee=c.length-girl.get(i);
                //System.out.println("ee"+ee);
                num_boy=ss+ee-k;

            }
            if (num_boy>max_num_boy)
                max_num_boy=num_boy;
        }
        //System.out.println(max_num_boy);

    }
}
/**
               1
 gbggbg gbb    gbb gb gbb g
 3
 */