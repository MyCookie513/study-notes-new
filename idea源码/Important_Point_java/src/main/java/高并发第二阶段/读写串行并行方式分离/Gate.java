package 高并发第二阶段.读写串行并行方式分离;



/**
 * 有一个门，始终只有一个人通过,通过这个门的同时记录这个passer 的个人信息；通过一个单线程实现这个功能；
 */
public class Gate {
    //对通过的数量计数；
    private  int counter;
    private String name="Nobody";
    private String adress="Nowwhere";

    public synchronized void pass(String name,String adress){
        counter++;
        this.name=name;
        this.adress=adress;
        verify();
    }

    public void verify(){
        if(this.name.charAt(0)!=this.adress.charAt(0)){
            System.out.println("*******ERROR*******"+toString());
        }
    }

    @Override
    public String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
