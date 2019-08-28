package java设计模式.工厂方法设计模式.Abstract_Factory_抽象工厂方法模式;

import java设计模式.工厂方法设计模式.Sender;

/**
 *在以上的工厂类中  ，如果想拓展新的Sender  ，那就要修改这个sender的Factory工厂的源码
 * 这样着实不方便；
 *解决方式： 就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，
 * 不需要修改之前的代码。因为抽象工厂不太好理解，我们先看看图，然后就和代码，就比较容易理解。
 * 也就是工厂类也做了接口封装
 *
 *
 */
public class Main {



    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();
    }





}
