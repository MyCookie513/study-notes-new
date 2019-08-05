package JUC_concurrency_ԭ����;

class CAS {
    // �ڴ�ֵ
    private volatile int value;

    // ��ȡ�ڴ�ֵ
    public synchronized int getValue() {
        return value;
    }

    //���۸��³ɹ�����ʧ�ܣ����᷵�ؾɵ��ڴ�ֵ
    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newValue;
        }

        return oldValue;
    }

    //�жϸ����Ƿ�ɹ���������³ɹ����ɵ��ڴ�ֵ���Ԥ��ֵ���
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}

public class TestCAS {

    public static void main(String[] args) {

        CAS cas = new CAS();

        //����10���߳���ģ����̻߳���
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
