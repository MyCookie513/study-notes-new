package 二叉树;
import java.util.LinkedList;
/*
 * 测试二叉树的  创建、遍历
 * 二叉树结构如下
 *            A
 *       B         C
 *    D     E   F     G
 *  H   I        J
 */
public class Main
{
    public static void main(String[] args)
    {
        BinaryTree<Character> binaryTree=new BinaryTree<>();

        //输入ABDH##I##E##CF#J##G##（#用null代替）
        LinkedList<Character> tree=new LinkedList<>();
        tree.add('A');tree.add('B');tree.add('D');
        tree.add('H');tree.add(null);tree.add(null);
        tree.add('I');tree.add(null);tree.add(null);
        tree.add('E');tree.add(null);tree.add(null);
        tree.add('C');tree.add('F');tree.add(null);
        tree.add('J');tree.add(null);tree.add(null);
        tree.add('G');tree.add(null);tree.add(null);

        System.out.println(tree.toString());
        BinaryTree<Character>.TreeNode<Character> root=binaryTree.creatBinaryPre(tree);

        //先序遍历（递归）
        binaryTree.pre_bianli(root);System.out.println();
        //中序遍历（递归）
        binaryTree.zhong_bianli(root);System.out.println();
        //后序遍历（递归）
        binaryTree.hou_bianli(root);System.out.println();


        //先序遍历（非递归）
        binaryTree.Pre_BianLi(root);System.out.println();
        //中序遍历（非递归）
        binaryTree.Zhong_BianLi(root);System.out.println();
        //后序遍历（非递归）
        binaryTree.PrintBinaryTreeBacUnrecur(root);System.out.println();
        //层次遍历（非递归）
      //  binaryTree.PrintBinaryTreeLayerUnrecur(root);System.out.println();


    }
}
