package 高并发第三阶段.Aotmic.CAS创建一个Lock;

public class GetLockException extends Exception {
    public GetLockException() {
    }

    public GetLockException(String message) {
        super(message);
    }
}
