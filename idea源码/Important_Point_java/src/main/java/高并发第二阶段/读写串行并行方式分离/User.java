package 高并发第二阶段.读写串行并行方式分离;

public class User extends Thread{
    private final String myName;
    private final String myAdress;
    private final Gate gate ;

    public User(String myName, String myAdress, Gate gate) {
        this.myName = myName;
        this.myAdress = myAdress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName+"Begin");
        while(true){
            this.gate.pass(myName,myAdress);
        }
    }
}
