package 高并发第二阶段.immutable不可变的设计模式;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Person person=new Person("jason","Binzhou");

        IntStream.range(0,5).forEach(i->{
            new usePersonThread(person).start();
        });
    }
}
