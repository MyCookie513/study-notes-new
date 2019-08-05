package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class test {


    private static  serviceImple serviceImple=new serviceImple();

    public static void main(String[] args) {

        ServiceInterface serviceInterface= (ServiceInterface) Proxy.newProxyInstance(serviceImple.getClass().getClassLoader(),
                serviceImple.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("事务开启");
                        Object obj=method.invoke(serviceImple,args);
                        System.out.println("事务关闭");
                        return obj;
                    }
                });


        serviceInterface.Doing();
    }




}
