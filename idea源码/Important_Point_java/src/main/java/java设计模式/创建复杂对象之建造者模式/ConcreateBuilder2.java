package java设计模式.创建复杂对象之建造者模式;

public class ConcreateBuilder2 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件x");
    }

    @Override
    public void buildPartB() {
        product.add("部件y");
    }

    @Override
    public Product GetResult() {
        return product;
    }
}
