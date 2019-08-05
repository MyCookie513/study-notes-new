package 动态代理.较详细版;

public class Student implements Person{


    public void sayHello(String content, int age) {
        System.out.println("student say hello" + content + " "+ age);

    }

    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);

    }

}

