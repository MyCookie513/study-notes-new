package java设计模式.创建复杂对象之建造者模式;

public class Main {
    public static void main(String[] args) {
        //创建构建逻辑
        Director director = new Director();

        //形成构建的具体组件
        Builder b1 = new ConcreateBuilder1();
        Builder b2 = new ConcreateBuilder2();

        //把组件交付给管家进行逻辑构建
        director.Construct(b1);

        Product p1 = b1.GetResult();

        p1.show();

        director.Construct(b2);
        Product p2 = b2.GetResult();
        p2.show();
    }
}
