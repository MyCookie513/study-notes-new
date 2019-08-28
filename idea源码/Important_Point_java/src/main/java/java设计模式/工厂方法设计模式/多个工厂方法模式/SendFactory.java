package java设计模式.工厂方法设计模式.多个工厂方法模式;

import java设计模式.工厂方法设计模式.MailSender;
import java设计模式.工厂方法设计模式.Sender;
import java设计模式.工厂方法设计模式.SmsSender;

public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
