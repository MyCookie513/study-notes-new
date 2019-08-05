package com.jason.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;


import java.sql.Statement;
import java.util.Properties;

/**
 * 动态的改变查询sql的参数；
 */
@Intercepts(
        {
                @Signature(type= StatementHandler.class,method ="parameterize" ,args = Statement.class )
        }
)
public class Change_parameter_interceptor implements Interceptor {

        public Object intercept(Invocation invocation) throws Throwable {
            Object target =invocation.getTarget();
            //statementHandler ----> parameterHandler --->parameterObject
            //拿到一个对象里面的所有的元素；
            MetaObject metaObject= SystemMetaObject.forObject(target);
            Object value=metaObject.getValue("parameterHandler.parameterObject");
            System.out.println("Change_parameter_interceptor 拦截到的参数为"+value);
            metaObject.setValue("parameterHandler.parameterObject","%lo%");
            //放行
            Object obj=invocation.proceed();


            return obj;
        }

        public Object plugin(Object target) {
            System.out.println("Change_parameter_interceptor 可以拦截的对象：" +target.getClass());
            Object proxy= Plugin.wrap(target,this);
            return proxy;
        }

    public void setProperties(Properties properties) {

    }
}
