package 高并发第二阶段.观察者设计模式;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    // todo 中心处 维护着自己的 一个粉丝 队列；
    private List<Observer> observers =new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void attach(Observer new_observer){
        observers.add(new_observer);
    }


    public void setState(int state) {
        if(this.state==state)
            return;
        this.state = state;
        notifyAllObserver();
    }

    private void notifyAllObserver(){
        observers.stream().forEach(Observer::update);
    }


}
