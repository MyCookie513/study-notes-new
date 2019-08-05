package 高并发第二阶段.流水线设计模式;

public class Request {

    private String name ;
    private int number ;

    public Request(String name, int i) {
        this.name=name;
        this.number=i;
    }
    @Override
    public String toString() {
        return "name: "+name +"number: "+number;
    }
    public void excute(){
        System.out.println(Thread.currentThread().getName()+"  操作:  "+this.toString());
    }
}
