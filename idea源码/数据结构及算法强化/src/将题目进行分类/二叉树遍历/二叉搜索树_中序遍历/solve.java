package 将题目进行分类.二叉树遍历.二叉搜索树_中序遍历;


/**
 * 二叉搜索树： 对于每一个节点来说，若它的左节点不为空，左节点肯定根节点，根节点肯定小于右节点；
 * 这样的话： 二叉搜索树的中序遍历，便是从小到大来遍历节点；
 * 所以寻找第k小值：
 *
 */

class solve {

    private boolean a=false;
    private int res, count;
    public int kthSmallest(TreeNode root, int k) {

        //中序遍历
        //来到一个节点
        //1.先看有没有左节点，
             //有，则递归左节点
        if (root.left!=null){
            int re= kthSmallest(root.left,k);
            if (a==true)
                return re;
        }
        System.out.println(root.val);
        //遍历 中 节点；
        if (k==1) {
            a=true;
            return root.val;
        }
        k--;

        //遍历右节点；
        if (root.right!=null){
            int re= kthSmallest(root.right,k);
            if (a== true)
                return re;
        }
        return 0;
    }

    public int kthSmallest0(TreeNode root, int k) {
        count = k;
        inorder(root);
        return res;
    }
    private void inorder(TreeNode root) {
        if(root == null || count == 0) return; //
        inorder(root.left);//遍历左子树
        if(--count == 0) res = root.val; //遍历当前树；
        inorder(root.right);//遍历右子树
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}





