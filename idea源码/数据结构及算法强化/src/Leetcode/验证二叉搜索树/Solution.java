package Leetcode.验证二叉搜索树;

public class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root==null)
            return true;
        return verify(null,root.left,root) && verify(root,root.right,null);
    }

    private boolean verify(TreeNode min , TreeNode node, TreeNode max) {

        if (node==null)
            return true;
        if (min!=null && node.val<=min.val)
            return false;
        if (max!=null && node.val>=max.val)
            return false;

        return verify(min,node.left,node) && verify(node,node.right,max);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
