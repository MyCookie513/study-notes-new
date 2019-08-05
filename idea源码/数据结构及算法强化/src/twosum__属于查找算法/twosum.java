package twosum__属于查找算法;

/**
 *  比较低级的遍历算法: 时间复杂度： O(n2)  空间复杂度：O(1)
 */
public class twosum {

    public int[] twoSum(int[] nums, int target) {
        int[] a=new int[2];
        for(int i=0;i<nums.length;i++){

            a[0]=i;
            int tg=target-nums[i];
            for (int j=i+1;j<nums.length;j++){

                if (tg==nums[j]){
                    a[1]=j;
                    return a;
                }

            }
        }
         return a;
    }
}
