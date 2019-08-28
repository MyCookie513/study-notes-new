package java设计模式.适配器模式.对象的适配器模式;

public class Main {

    public static void main(String[] args) {
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

}
