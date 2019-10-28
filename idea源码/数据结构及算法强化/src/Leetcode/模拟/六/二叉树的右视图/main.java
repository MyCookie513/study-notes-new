package Leetcode.模拟.六.二叉树的右视图;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class main {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        LinkedList<TreeNode> queue =new LinkedList<>();
        list.clear();
        if (root==null)
            return list;

        queue.addFirst(root);
        TreeNode left;
        while (queue.size()!=0){
           int size=queue.size();
            left =queue.removeFirst();
            list.add(left.val);
            if (left.right!=null)
                queue.addLast(left.right);
            if (left.left!=null)
                queue.addLast(left.left);
            for (int i = 0; i < size-1; i++) {
                TreeNode treeNode =queue.removeFirst();
                if (treeNode.right!=null)
                    queue.addLast(treeNode.right);
                if (treeNode.left!=null)
                    queue.addLast(treeNode.left);
            }


        }


        return list;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
