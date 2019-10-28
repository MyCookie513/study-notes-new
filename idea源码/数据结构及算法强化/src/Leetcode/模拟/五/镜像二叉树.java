package Leetcode.模拟.五;

public class 镜像二叉树 {





    public boolean isSymmetric(TreeNode root) {


        if (root==null )
            return true;

        return  fs(root.left,root.right);


    }

    private boolean fs(TreeNode left, TreeNode right) {
        if ((left==null && right !=null ) || (left != null && right ==null ) )
            return false;

        if (left==null && right ==null )
            return true;

        if (left.val!=right.val)
            return false;

        if ( fs(left.right,right.left) &&fs(left.left,right.right))
          return true ;

        return false;

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



}
