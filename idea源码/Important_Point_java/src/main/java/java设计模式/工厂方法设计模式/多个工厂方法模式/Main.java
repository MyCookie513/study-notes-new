package java设计模式.工厂方法设计模式.多个工厂方法模式;

import java设计模式.工厂方法设计模式.Sender;

public class Main {



    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }



}
