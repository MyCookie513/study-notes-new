package java设计模式.创建复杂对象之建造者模式;

public class ConcreateBuilder1 extends Builder {
    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product GetResult() {
        return product;
    }
}
