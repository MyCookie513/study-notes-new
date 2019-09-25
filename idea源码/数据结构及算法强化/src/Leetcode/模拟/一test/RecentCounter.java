package Leetcode.模拟.一test;

import java.util.LinkedList;

public class RecentCounter {


    LinkedList<Integer > queue =new LinkedList<>();


    public RecentCounter() {

    }

    public int ping(int t) {

        int t0=t-3000;

        while (!queue.isEmpty()){
            int i=queue.peekFirst();
            if (i>=t0)
                break;
            queue.removeFirst();
        }

        queue.addLast(t0);
        return queue.size()+1;
    }


}
