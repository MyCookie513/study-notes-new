package 高并发第二阶段.producerAndConsumer模式;

public class  Message_ {
    private String data;

    public Message_(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
