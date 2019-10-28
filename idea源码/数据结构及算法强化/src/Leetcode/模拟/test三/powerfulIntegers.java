package Leetcode.模拟.test三;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class powerfulIntegers {


    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        int i=0;

        while (true){
            double g=Math.pow(x,i);
            i++;
            if (g>bound)
                break;
            int  j=0;
            while (true){
                double h=Math.pow(y,j);
                int he=(int)(h+g);
                if (he>bound)
                    break;
                if (!set.contains(he)){
                    set.add(he);
                    list.add(he);
                }
                j++;
                if (y==1)
                    break;
            }
            if (x==1)
                break;
        }

        return list;
    }










}
