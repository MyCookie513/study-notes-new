package 线段树;

public class Query_Range_Update_Range {





    /*构造函数根据区间创建数组的范围*/
    public Query_Range_Update_Range(int[] nums) {

        Seg_Tree seg_tree=new Seg_Tree(nums);

    }

    public static void main(String[] args) {

        int[] nums={1,2,3,4,5,6};

        Seg_Tree seg_tree=new Seg_Tree(nums);

       Seg_Tree.Node root= seg_tree.Build(0,nums.length-1);

       seg_tree.Update_Single(root,3,6);
       seg_tree.Update_prototype(root,0,3,8);
        System.out.println(seg_tree.Query(root,2,3));


    }
























}

class Seg_Tree{



    private int[]  a;
    private Node[]  T;



    /**
     * T  :  为构建树的数组；
     * @param a :segment data;
     */
    public Seg_Tree(int[] a) {
        this.a = a;
        T=new Node[a.length<<2];
    }



    /**
     *
     * 根据segment递归建树 l：左边界  r: 右边界
     *   1.如果为一个叶子节点，则将data以及segment赋给它，然后返回节点的引用
     *
     *   2.如果作为一个非叶子节点
     *
     *      1.先划分区间，创建子树，然后根据子树得到data以及对子树的引用，然后返回其引用
     *
     *
     *
     */
    public Node  Build(int l,int r){

        if(l==r){
         return new Node(a[l],l,r,null,null);
        }else if(l<r){
            int mid =(l+r)>>1;
            Node Lson=Build(l,mid);
            Node Rson=Build(mid+1,r);
            return new Node(Lson.data+Rson.data,l,r,Lson,Rson);
        }else
            return null;
    }

    /**
     *核心：
     *    1.如果查询的区间和此节点树代表的区间相同，直接返回此节点树的data
     *
     *    2.如果Query segment is 节点树的真子集；进行判定
     *
     *       1.全部为LSon  递归进行查询
     *       2.全部在RSon   递归进行查询
     *       3.交叉    递归分部查询
     *
     * @param root:在树的根节点开始搜索
     * @param l：查询的区间的左边界
     * @param r：查询的区间的右边界
     * @return
     */
    public int Query(Node root ,int l,int r){

        if(root.L==l&&root.R==r){
            return root.data;
        }else{

            int mid =root.Lson.R;
            if(r<=mid){/*全部在左边*/
                return Query(root.Lson,l,r);
            }else if(l>mid){/*全部在右区间*/
                return Query(root.Rson,l,r);
            }else{/*左右区间交叉*/
                return Query(root.Lson,l,mid)+Query(root.Rson,mid+1,r);
            }
        }


    }


    public void Update_Single(Node root,int index,int value){

        if(root.L==index&&root.R==index){
            root.data=value;
        }else{

            int mid=root.Lson.R;
            if(index<=mid){
                Update_Single(root.Lson,index,value);
            }else{
                Update_Single(root.Rson,index,value);
            }

            root.data=root.Lson.data+root.Rson.data;
        }
    }


    /**
     * 将区间内的值全部更新为value;
     *  1.如果节点区间和更新区间完全重合，则继续进行递归直到为叶子节点
     *  2.如果两个区间不重合则进行，分段更新
     *  3.最后更新父节点
     *
     * @param root
     * @param l
     * @param r
     * @param value
     */
    public void Update_prototype(Node root,int l,int r,int value){

        if(root.L==l&&root.R==r){
            if(l==r){
                root.data=value;
            }else {
                Update_prototype(root.Lson,root.Lson.L,root.Lson.R,value);
                Update_prototype(root.Rson,root.Rson.L,root.Rson.R,value);
                root.data=root.Lson.data+root.Rson.data;
            }

        }else{
            int mid =root.Lson.R;
            if(mid>=r){//如果全部在左区间
                Update_prototype(root.Lson,l,r,value);
            }else if(mid <l){//如果全部在右区间
                Update_prototype(root.Rson,l,r,value);
            }else{//交叉情况
                Update_prototype(root.Lson,l,mid,value);
                Update_prototype(root.Rson,mid+1,r,value);
            }
            root.data=root.Lson.data+root.Rson.data;
        }


    }

    /**
     * L:代表区间的左边界
     * R:代表区间的右边界
     * data：综合值，根据具体的情况而定；
     * Lson: 指向的分区间的左子树
     * Rson： 指向的分区间的右子树；
     */
    class Node {

        int data;
        int L;
        int R;
        Node Lson;
        Node Rson;
        public Node(int data, int l, int r, Node lson, Node rson) {
            this.data = data;
            L = l;
            R = r;
            Lson = lson;
            Rson = rson;
        }
    }





}





















