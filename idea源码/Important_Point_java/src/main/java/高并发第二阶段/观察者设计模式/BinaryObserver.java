package 高并发第二阶段.观察者设计模式;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String:"+Integer.toBinaryString(subject.getState()));
    }
}
