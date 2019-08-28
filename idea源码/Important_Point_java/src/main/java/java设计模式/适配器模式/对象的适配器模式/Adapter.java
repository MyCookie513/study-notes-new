package java设计模式.适配器模式.对象的适配器模式;

import java设计模式.适配器模式.Source;

public class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
