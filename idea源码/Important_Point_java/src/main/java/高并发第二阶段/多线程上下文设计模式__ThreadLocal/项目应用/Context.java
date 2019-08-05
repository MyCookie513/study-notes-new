package 高并发第二阶段.多线程上下文设计模式__ThreadLocal.项目应用;

public class Context {

    private String name ;
    private String card ;

    public  void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCard(String card) {
        this.card=card ;
    }

    public String getCard() {
        return card;
    }
}
