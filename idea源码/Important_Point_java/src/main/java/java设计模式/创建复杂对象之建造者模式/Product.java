package java设计模式.创建复杂对象之建造者模式;

import java.util.ArrayList;
import java.util.List;

public class Product {

    List parts = new ArrayList();

    public void add(String part){
        parts.add(part);
    }

    public void show(){
        System.out.println("产品创建----");
        for (Object part : parts) {
            System.out.println(part);
        }
    }

}
