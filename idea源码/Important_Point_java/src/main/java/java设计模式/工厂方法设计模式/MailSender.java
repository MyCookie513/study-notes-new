package java设计模式.工厂方法设计模式;

import java设计模式.工厂方法设计模式.Sender;

public class MailSender implements Sender {
    @Override
    public void Send() {
        System.out.println("this is mailsender!");
    }
}
