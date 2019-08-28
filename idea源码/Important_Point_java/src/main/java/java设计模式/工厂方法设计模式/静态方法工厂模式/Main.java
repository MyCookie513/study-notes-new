package java设计模式.工厂方法设计模式.静态方法工厂模式;

import java设计模式.工厂方法设计模式.Sender;

public class Main {



    public static void main(String[] args) {
        Sender sender = SendFactory.produceMail();
        sender.Send();
    }

}
