package java设计模式.工厂方法设计模式.普通工厂模式;

import java设计模式.工厂方法设计模式.MailSender;
import java设计模式.工厂方法设计模式.Sender;
import java设计模式.工厂方法设计模式.SmsSender;

public class SendFactory {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("请输入正确的类型!");
            return null;
        }
    }
}
