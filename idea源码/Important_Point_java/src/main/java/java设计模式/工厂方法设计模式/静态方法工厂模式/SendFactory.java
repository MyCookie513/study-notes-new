package java设计模式.工厂方法设计模式.静态方法工厂模式;

import java设计模式.工厂方法设计模式.MailSender;
import java设计模式.工厂方法设计模式.Sender;
import java设计模式.工厂方法设计模式.SmsSender;

public class SendFactory {



    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

}
