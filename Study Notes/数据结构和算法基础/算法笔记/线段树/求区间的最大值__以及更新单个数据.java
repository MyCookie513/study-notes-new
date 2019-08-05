package 线段树;

import java.util.Scanner;

public class 求区间的最大值__以及更新单个数据 {

    private static int[] srcArray;
    private static TreeNode[] nodes = new TreeNode[30001 << 2];
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int N, M;
        while (scan.hasNext()) {

            N = scan.nextInt();
            M = scan.nextInt();
            /*构建树，将叶子节点的值传进去同时更新非叶子节点的值*/
            Build(1, 1, N);
            for (int i = 0; i < M; i++) {
                String c = scan.next();
                int a = scan.nextInt();
                int b = scan.nextInt();
                if (c.equals("Q")) {
                    System.out.println(Query_Single(1,Math.min(a, b), Math.max(a, b)));
                } else {
                    Update_single(1, a, b);
                }
            }

        }

    }



    /*线段树的构造函数*/
    static void Build(int pid, int L, int R) {
        /*初始化第pid个节点的数据域*/


        int p=pid;
        nodes[pid] =  new TreeNode();

        /*此节点管辖的范围*/
        nodes[pid].L = L;
        nodes[pid].R = R;

        /*如果为叶子节点，则写入节点值*/
        if (L == R) {

            int data = scan.nextInt();
            nodes[pid].data = data;
            return;
        }

        /*将多个节点拆分为单个节点*/
        if (L < R) {
            int mid = (L + R) >> 1;
            /*递归构造左子树*/
            Build(pid << 1, L, mid);
            Build(pid << 1 | 1, mid + 1, R);
            /*进行合并操作*/
            nodes[p].updateFromSon(p);

        }

    }


    /*树节点的构建；
     * */
    static class TreeNode {

        int data;

        int R, L;



        /*将此节点和另一个节点的data更新到自己的的data域*/

        void merge_update(int pid) {
            data = Math.max(data, nodes[pid].data);
        }


        /*根据左子树和右子树来更新根节点的值*/
        void updateFromSon(int pid) {
            //将左子树的data更新到自己的data；
            data = nodes[pid << 1].data;
            //然后再将右子树的data更新到自己的data；
            merge_update(pid << 1 | 1);
        }

        public static int Lson(int pid) {
            return pid << 1;
        }

        public static int Rson(int pid) {
            return pid << 1 | 1;
        }
    }


    static void Update_single(int root, int index, int upvalue) {

        /*如果此节点是个叶子节点，并且节点管辖的范围为index 单值 ,则更新这个这个值*/
        if (index == nodes[root].L && index == nodes[root].R) {
            nodes[root].data = upvalue;
            return;
        }

        /*如果此节点不是叶子节点*/

        int mid = (nodes[root].L + nodes[root].R) >> 1;
        if (index <= mid) {
            Update_single(TreeNode.Lson(root), index, upvalue);

        } else {
            Update_single(TreeNode.Rson(root), index, upvalue);
        }
        /*子节点更新后，更新父节点的值*/
        nodes[root].updateFromSon(root);

    }


    static int Query_Single(int root, int QL, int QR) {

        /*如果不在查询范围内直接返回0*/
        if (nodes[root].R < QR && nodes[root].L > QL) {
            return 0;
        }

        /*如果一个节点正好对应了所查找的范围，则将这个节点的data值返回即可*/
        if (QL == nodes[root].L && QR == nodes[root].R) {
            return nodes[root].data;
        }

        /*如果此时查询的范围远小于这个节点的管辖范围，就要对访问这个节点的子节点
         * 有三种情况
         * 1.全部在根节点的左半球，
         * 2.全部在根节点的右半球，
         * 3.脚踏左半球和右半球两只船；
         * */
        int mid = (nodes[root].L + nodes[root].R) >> 1;

        if (QR <= mid)
            return Query_Single(TreeNode.Lson(root), QL, QR);
        else if (QL > mid)
            return Query_Single(TreeNode.Rson(root), QL, QR);
        else {
            return Math.max(Query_Single(TreeNode.Lson(root), QL, mid),
                    Query_Single(TreeNode.Rson(root), mid + 1, QR));
        }


    }


    /*线段树的更新,更新数组在【x,y】区间上的值；
     * 更新过程采用二分，将{1，n}区间不断分割直到x-y区间完全包括这个区间
     * 就更新管辖的完全包括的这段区间的节点的数据；
     * */
    static void Query(int pid, int L, int R, int x, int y, int qu_value) {

        /*如果x-y与L-R无交集，直接返回*/
        if (is_intersect(L, R, x, y)) {
            return;
        }
        /*如果此区间是x-y的子集，则更新这个数据域*/
        if (is_allcontaint(L, R, x, y)) {
            /*在此进行更新进行查询的值；*/

            return;
        }




        /*如果x-y只有一部分交集，则先进行下一步的分割判定*/
        int mid = (L + R) >> 1;
        Query(pid << 1, L, mid, x, y, qu_value);
        Query(pid << 1 | 1, mid + 1, R, x, y, qu_value);
        /*利用左右子数的信息更新当前节点*/


    }


    /*线段树的更新,更新数组在【x,y】区间上的值；
     * 更新过程采用二分，将{1，n}区间不断分割直到x-y区间完全包括这个区间
     * 就更新管辖的完全包括的这段区间的节点的数据；
     * */
    static void Update(int pid, int L, int R, int x, int y, int up_value) {

        /*如果x-y与L-R无交集，直接返回*/
        if (is_intersect(L, R, x, y)) {
            return;
        }
        /*如果此区间是x-y的子集，则更新这个数据域*/
        if (is_allcontaint(L, R, x, y)) {
            /*在此进行更新这个区间的所有的数据节点*/

            return;
        }




        /*如果x-y只有一部分交集，则先进行下一步的分割判定*/
        int mid = (L + R) >> 1;
        Update(pid << 1, L, mid, x, y, up_value);
        Update(pid << 1 | 1, mid + 1, R, x, y, up_value);
        /*利用左右子数的信息更新当前节点*/


    }


    private static boolean is_allcontaint(int l, int r, int x, int y) {
        return true;

    }

    private static boolean is_intersect(int l, int r, int x, int y) {

        return true;
    }


}
