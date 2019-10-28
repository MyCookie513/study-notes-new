package Leetcode.二叉树中的最大路径和;

public class Solution {

    private  int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        houxu(root);
        return result;
    }

    private TreeNode houxu(TreeNode root) {

        if (root==null)
            return null;

        TreeNode L =houxu(root.left);
        TreeNode R =houxu(root.right);

        int max =root.val;
        //todo
        if (root.val>=0){
            if (L!=null && L.val>0){
                max=max+L.val;
            }
            if (R!=null && R.val>0){
                max=max+R.val;
            }
        }else{
            if (L!=null)
                max=Math.max(max,L.val);
            if (R!=null)
                max=Math.max(max,R.val);
            if (L!=null && R!=null)
                max=Math.max(max,L.val+root.val+R.val);
        }

        System.out.println(max);
        if (max>result)
            result=max;

        //todo return
       int L0=0,R0=0;
        if (L!=null && L.val>0){
            L0=root.val+L.val;
        }
        if (R!=null && R.val>0){
            R0=root.val+R.val;
        }

        //todo 子节点贡献是负值的话，还不如不贡献，所以应该直接返回null ;返回零的话

        int y=Math.max(L0,R0);
        y=Math.max(y,root.val);
        if (y>0)
            return new TreeNode(y);
        else{
            return null;
        }


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


}
