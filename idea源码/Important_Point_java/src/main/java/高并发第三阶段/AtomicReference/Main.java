package 高并发第三阶段.AtomicReference;

import java.util.concurrent.atomic.AtomicReference;

public class Main {


    public static void main(String[] args) {
        Simple simple=new Simple("张三",18);
        AtomicReference<Simple> atomicReference=new AtomicReference<>(simple);


        System.out.println();
        boolean success= atomicReference.compareAndSet(simple,new Simple("zhangsan",19));
        System.out.println(success);
        System.out.println(atomicReference.get());
    }


    /**
     * 把这个类定义成final类，想改都不能改；
     */
    static final class Simple{
        private final String name ;
        private final int age;

        public Simple(String name, int age) {
            this.name = name;
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
