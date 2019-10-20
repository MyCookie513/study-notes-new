package 高并发第二阶段.观察者设计模式;

public abstract class Observer {

    protected Subject subject;
    public abstract void update() ;

    public Observer(Subject subject) {
      this.subject=subject;
      this.subject.attach(this);
    }
}
