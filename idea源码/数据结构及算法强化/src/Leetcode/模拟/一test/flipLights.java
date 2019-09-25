package Leetcode.模拟.一test;

import java.util.*;
import java.util.logging.Handler;

public class flipLights {

    /**
     *
     * todo 一共有四种操作 ，每一种操作产生的结果只有这个操作的次数有 单数和偶数两种结果；
     *      所以一共有16 种  操作集合；
     *
     * todo  不管所有的灯泡的长度有多长 ，6个一周期；
     *
     * n :灯泡的个数；
     * m :操作的次数；
     *
     * todo 可以利用 ^ 来进行 1 标志位的状态的反转；
     *
     */
    public int flipLights0(int n, int m) {
        int x= Math.max(0,6-n);
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < 16; i++) {

            int result=0;
            int acount =Integer.bitCount(i);
            if (m >=acount && m%2 ==acount%2){
                System.out.println(i);
                if ((i&0b0001) ==1){
                    result= result ^ (0b111111>>x);
                }
                if ((i&0b0010) ==1){
                    result= result ^ (0b010101>>x);
                }
                if ((i&0b0100) ==1){
                    result= result ^ (0b101010>>x);
                }
                if ((i&0b1000) ==1){
                    result= result ^ (0b000100>>x);
                }
            }
            set.add(result);

        }
        return set.size();
    }


    /**
     * 2^N个灯光的状态，4^M个操作顺序
     *
     *
     * todo 前6个灯唯一地决定了其余的灯。这是因为每一个修改 第 x 的灯光的操作都会修改第 (x+6)的灯光。   改变了 灯光的数目
     *
     * todo 另外：进行 A 操作后接 B 操作 和 B 操作后接 A 操作是一样的，所以我们可以假设我们按顺序进行所有操作。
     *
     * todo 最后，连续两次执行相同的操作与不执行任何操作相同。所以我们只需要考虑每个操作是 0 次还是 1 次。
     *
     *
     *
     * @param n
     * @param m
     * @return
     */

    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet();

        //6个灯泡 为一个周期
        n = Math.min(n, 6);


        int shift = Math.max(0, 6-n);


        //执行下来一共有16种可能；
        for (int cand = 0; cand < 16; ++cand) {

            //计算出有几个亮的灯泡
            int bcount = Integer.bitCount(cand);

            if (bcount % 2 == m % 2 && bcount <= m) { //todo bcount % 2 == m % 2 代表操作必须是单数或者偶数的限制才能凑出 m次操作

                int lights = 0;

                if (((cand >> 0) & 1) > 0) //todo 是否有第一种类型的操作 ： 也就是全部反一下
                    lights ^=    0b111111 >> shift;//todo  >> shift ： 代表  如果灯泡不足 6个    需要右移一下
                if (((cand >> 1) & 1) > 0)
                    lights ^=    0b010101 >> shift;
                if (((cand >> 2) & 1) > 0)
                    lights ^=    0b101010 >> shift;
                if (((cand >> 3) & 1) > 0)
                    lights ^=    0b100100 >> shift;

                seen.add(lights);
            }

        }


        return seen.size();
    }


}
