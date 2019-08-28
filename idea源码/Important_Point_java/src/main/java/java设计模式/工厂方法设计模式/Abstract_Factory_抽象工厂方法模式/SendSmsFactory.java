package java设计模式.工厂方法设计模式.Abstract_Factory_抽象工厂方法模式;

import java设计模式.工厂方法设计模式.Sender;
import java设计模式.工厂方法设计模式.SmsSender;

public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}