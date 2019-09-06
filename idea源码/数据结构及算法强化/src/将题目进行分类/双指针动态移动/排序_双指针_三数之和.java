package 将题目进行分类.双指针动态移动;

import java.util.*;

public class 排序_双指针_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();

        if (nums.length<3)
            return null;
        Map<String,Object> map=new HashMap<>();
        Arrays.sort(nums);
        for (int x=1;x<nums.length-1;x++){
            int i=0,j=nums.length-1;
            while (i<x && j>x){
                int v=nums[i]+nums[j]+nums[x];
                if (v != 0) {
                    if (v<0){
                        i++;
                    }else{
                        j--;
                    }
                }else{
                    if (!map.containsKey(""+nums[i]+"/"+nums[x]+"/"+nums[j])){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[x]);
                        list.add(nums[j]);
                        res.add(list);
                        map.put(""+nums[i]+"/"+nums[x]+"/"+nums[j],null);
                    }
                    i++;
                    j--;
                }

            }

        }

        return res;
    }

}
