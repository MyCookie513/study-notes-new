package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

import javax.swing.*;

public final class ActionContest
{
    private static final ThreadLocal<Context> threadLocal=new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    //单例模式获取一个动态的保险箱对象；
    private static class ActionContetHolder {
        private static ActionContest actionContest=new ActionContest();
        private static ActionContest getActionContest(){
            return actionContest;
        }
    }
    //开放一个口用于获取实例对象；
    public static  ActionContest getInstance(){
        return ActionContetHolder.getActionContest();
    }

    //用于获取本地线程中的上下文对象；
    public Context getConext(){
        return threadLocal.get();
    }




}
