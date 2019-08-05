package 高并发第三阶段.AtomicStampedReference;

import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    private static Simple simple=new Simple("zhangsan",18);
    static AtomicStampedReference<Simple> atomicStampedSimple=new AtomicStampedReference<>(simple,0);

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    boolean success= atomicStampedSimple.compareAndSet(simple,new Simple("张三",18),atomicStampedSimple.getStamp(),atomicStampedSimple.getStamp()+1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                     int stamp=atomicStampedSimple.getStamp();
                    Thread.sleep(2000);
                    boolean success= atomicStampedSimple.compareAndSet(simple,new Simple("张三",18),stamp,stamp+1);
                    System.out.println(success);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 把这个类定义成final类，想改都不能改；
     */
    static  class Simple{
        private  String name ;
        private  int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Simple{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
