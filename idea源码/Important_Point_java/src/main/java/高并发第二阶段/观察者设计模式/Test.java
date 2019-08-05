package 高并发第二阶段.观察者设计模式;

public class Test {


    public static void main(String[] args) {
        final Subject subject=new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("====================================");
        subject.setState(100);
        System.out.println("====================================");
        subject.setState(666);
    }
}
