package 高并发第二阶段.Balking_阻碍放弃设计模式;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BalkingData {
    private  final String fileName ;
    private String content ;
    private boolean changed;


    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed=true;
    }
    public synchronized void change(String new_content){
        while (changed==true) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.content=new_content;
        changed=true;
        this.notifyAll();

    }
    public synchronized  void save() {
        while (changed==false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            doSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        changed=false;
        this.notifyAll();

    }


    /**
     *
     * @throws IOException
     */
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName()+" do save :"+this.content);

        try(Writer writer=new FileWriter(fileName,true)){
            writer.write(content);
            writer.write("\n");
            writer.flush();
        }
    }
}
