package 高并发第二阶段.观察者设计模式;

public class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String:"+Integer.toOctalString(subject.getState()));
    }
}
