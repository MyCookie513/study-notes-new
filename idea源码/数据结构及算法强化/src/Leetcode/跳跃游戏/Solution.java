package Leetcode.跳跃游戏;

public class Solution {

    public boolean canJump(int[] nums) {
        int len =nums.length;
        int x=nums[0];
        int index=0;
        while (index<len && x>=0){
            if (nums[index]>x){
                x=nums[index];
            }
            index++;
            x--;
        }
        if (index==len && x>=-1){
            return true;
        }
        return false;

    }




}
