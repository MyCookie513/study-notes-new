package twosum__属于查找算法;

import java.util.HashMap;
import java.util.Map;

public class Second {
    public int[] twoSum(int[] nums, int target) {
        int[] a=new int[2];
        Map<Integer ,Integer> map=new HashMap<>();
        int tg;
        for (int i=0;i<nums.length;i++){

            tg=target-nums[i];
            if (map.containsKey(tg))
            {
                a[0]=map.get(tg);
                a[1]=i;
                return a;
            }
            map.put(nums[i],i);

        }
        return a;
    }
}
