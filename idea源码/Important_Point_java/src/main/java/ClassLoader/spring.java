package ClassLoader;

public class spring {

    public int get(){
        return 6;
    }

    public static void main(String[] args) {


        Node node=Node.getInstance();
        //调用静态方法，触发了整个class的初始化
        //1.链接阶段的完成；准备好了内存空间和初始化值0或者null
        //2.i=2,  从上到下，静态属性的初始化
            //public static Node node=new Node();  静态成员的初始化
                    //Node()构造函数的调用；
        //再往下： 静态块的初始化
        //System.out.println(node.i);
        //System.out.println(Node.i);

    }



}
class Node{

    public static Node node=new Node();

    public static int i=2;
    int x=0;
    static {
        System.out.println("静态成员的初始化 ");
    }
    {
        System.out.println("普通成员的初始化");
    }
    public Node(){
        System.out.println("构造函数的初始化");
        System.out.println(i);
        i++;
    }
    public static Node getInstance(){
        return node;
    }

}