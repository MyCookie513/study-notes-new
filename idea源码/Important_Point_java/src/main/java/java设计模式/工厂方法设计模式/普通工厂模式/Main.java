package java设计模式.工厂方法设计模式.普通工厂模式;

import java设计模式.工厂方法设计模式.Sender;

/**
 * 用接口实现不同功能的嵌套类，然后用工厂来生产
 */
public class Main {




    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("sms");
        sender.Send();
    }


}
