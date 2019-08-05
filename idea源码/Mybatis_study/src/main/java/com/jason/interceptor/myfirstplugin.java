package com.jason.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;


import java.sql.Statement;
import java.util.Properties;

/**
 *
 *完成插件的签名：
 *          告诉mybatis当前插件用来拦截那个对象的那个方法；
 */
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method ="parameterize" ,args = Statement.class )
        }
)
public class myfirstplugin implements Interceptor {
    /**
     * interceptor  : 拦截目标方法对象的执行；
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("myfirstplugin ---Method："+invocation.getMethod());
        //代表了目标方法的放行
        Object obj=invocation.proceed();
        return obj;
    }

    /**
     *  pugin  ：包装目标对象  ，为目标对象创建一个代理对象
     * @param target
     * @return
     */
    public Object plugin(Object target) {
        System.out.println("myfirstplugin 可以拦截的对象：" +target.getClass());
        Object proxy= Plugin.wrap(target,this);
        return proxy;
    }

    /**
     * 将插件注册时的信息注入进来
     * @param properties
     */
    public void setProperties(Properties properties) {

    }
}
