package JUC_concurrency_原子性;

class CAS {
    // 内存值
    private volatile int value;

    // 获取内存值
    public synchronized int getValue() {
        return value;
    }

    //无论更新成功还是失败，都会返回旧的内存值
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    //判断更新是否成功，如果更新成功，旧的内存值会和预估值相等
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}

public class TestCAS {

    public static void main(String[] args) {

        CAS cas = new CAS();

        //创建10个线程来模拟多线程环境
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    int expectedValue = cas.getValue();
                    boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}
