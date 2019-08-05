package 高并发第二阶段.immutable不可变的设计模式;

public class usePersonThread extends Thread {


   private  Person person;

    public usePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+" print :" + person.toString());
        }
    }
}
