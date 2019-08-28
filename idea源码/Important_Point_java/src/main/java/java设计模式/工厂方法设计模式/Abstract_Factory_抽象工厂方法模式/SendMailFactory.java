package java设计模式.工厂方法设计模式.Abstract_Factory_抽象工厂方法模式;

import java设计模式.工厂方法设计模式.MailSender;
import java设计模式.工厂方法设计模式.Sender;

public class SendMailFactory implements Provider {

    @Override
    public Sender produce(){
        return new MailSender();
    }
}