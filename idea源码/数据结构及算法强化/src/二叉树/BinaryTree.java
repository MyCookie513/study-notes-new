package 二叉树;

import javax.swing.plaf.PanelUI;
import java.util.LinkedList;

public class BinaryTree<T>{


    /**
     * 二叉树内部一个节点的结构；
     * @param <T>
     */
    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 先序创建二叉树，   返回头节点
     * @param   treeData
     * @return
     */
    public TreeNode<T> creatBinaryPre(LinkedList<T> treeData){
        TreeNode<T> root =null;
        T data=treeData.removeFirst();
        if (data!=null)
        {
            root=new TreeNode<T>(data, null, null);
            root.left=creatBinaryPre(treeData);
            root.right=creatBinaryPre(treeData);
        }
        return root;

    }


    /****
     * 递归遍历：　先序遍历
     */

    public void pre_bianli(TreeNode<T> root){

        if(root!=null){
            System.out.print(root.data);
            pre_bianli(root.left);
            pre_bianli(root.right);
        }

    }



    /****
     * 递归遍历：　中序遍历
     */

    public void zhong_bianli(TreeNode<T> root){

        if(root!=null){
            zhong_bianli(root.left);
            System.out.print(root.data);
            zhong_bianli(root.right);
        }

    }

    /****
     * 递归遍历：　后序遍历
     */

    public void hou_bianli(TreeNode<T> root){

        if(root!=null){
            hou_bianli(root.left);
            hou_bianli(root.right);
            System.out.print(root.data);
        }

    }

    /**
     *非递归遍历  ： 先序遍历
     *
     * 算法思路：
     * 1.拿到一个节点后先遍历这个节点的左子树     同时将这个节点压入栈用于最后遍历右子树
     */

    public void Pre_BianLi(TreeNode<T> root){

        LinkedList<TreeNode<T>> stack =new LinkedList<>();
        //定义一个指针；
        TreeNode<T> p=root;
        while (p!=null || !stack.isEmpty()){

            if(p!=null){
                System.out.print(p.data);//访问这个当前节点
                stack.push(p);             //将这个节点压入stack 用于后期在树中的向上爬树 然后访问右子树
                p=p.left;                  //接下来尝试访问这个节点的左子树

            }else{
                //进入这个地方说明左子树已经遍历完成，向上爬树准备
                p=stack.pop();
                p=p.right;

            }


        }

    }




    /**
     *非递归遍历  ： 中序遍历
     *
     * 算法思路：
     * 1.拿到一个节点后先遍历这个节点的左子树     同时将这个节点压入栈用于最后遍历右子树
     */

    public void Zhong_BianLi(TreeNode<T> root){

        LinkedList<TreeNode<T>> stack =new LinkedList<>();
        //定义一个指针；
        TreeNode<T> p=root;
        while (p!=null || !stack.isEmpty()){

            if(p!=null){
                stack.push(p);             //将这个节点压入stack 用于后期在树中的向上爬树 然后访问右子树
                p=p.left;                  //接下来尝试访问这个节点的左子树

            }else{
                //进入这个地方说明左子树已经遍历完成，向上爬树准备
                p=stack.removeFirst();
                System.out.print(p.data);//访问这个当前节点
                p=p.right;

            }


        }

    }


    /**
     *非递归遍历  ： 后序遍历
     *
     * 算法思路：
     * 1.拿到一个节点后先遍历这个节点的左子树     同时将这个节点压入栈用于最后遍历右子树
     */

    public void Hou_BianLi(TreeNode<T> root){

        LinkedList<TreeNode<T>> stack =new LinkedList<>();
        //定义一个指针；
        TreeNode<T> p=root;
        while (p!=null || !stack.isEmpty()){

            if(p!=null){
                stack.push(p);             //将这个节点压入stack 用于后期在树中的向上爬树 然后访问右子树
                p=p.left;                  //接下来尝试访问这个节点的左子树

            }else{
                //进入这个地方说明左子树已经遍历完成，向上爬树准备
                p=stack.removeFirst();
                p=p.right;

            }


        }

    }

    /*
     * 后序遍历二叉树（非递归）
     *
     */
    public void PrintBinaryTreeBacUnrecur(TreeNode<T> root)
    {
        class NodeFlag<T>
        {
            TreeNode<T> node;
            char tag;
            public NodeFlag(TreeNode<T> node, char tag) {
                super();
                this.node = node;
                this.tag = tag;
            }
        }



        LinkedList<NodeFlag<T>> stack=new LinkedList<>();
        TreeNode<T> p=root;
        NodeFlag<T> bt;
        //栈不空或者p不空时循环
        while(p!=null || !stack.isEmpty())
        {
            //遍历左子树
            while(p!=null)
            {
                bt=new NodeFlag(p, 'L');
                stack.push(bt);
                p=p.left;
            }
            //左右子树访问完毕访问根节点
            while(!stack.isEmpty() && stack.getFirst().tag=='R')
            {
                bt=stack.pop();
                System.out.print(bt.node.data);
            }
            //遍历右子树
            if (!stack.isEmpty())
            {
                bt=stack.peek();
                bt.tag='R';
                p=bt.node;
                p=p.right;
            }
        }




    }
    /*
     * 层次遍历二叉树（非递归）
     */
    public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root)
    {
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode<T> p;
        queue.push(root);
        while(!queue.isEmpty())
        {
            p=queue.removeFirst();
            System.out.print(p.data);
            if (p.left!=null)
                queue.addLast(p.left);
            if (p.right!=null)
                queue.addLast(p.right);
        }
    }



}
