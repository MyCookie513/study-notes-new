package ThreadLocal;


public class test3 {  
	  
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>() {  
        protected Long initialValue() {  
            return Thread.currentThread().getId();  
        };  
    };  
      
    ThreadLocal<String> stringLocal = new ThreadLocal<String>() {  
        protected String initialValue() {  
            return Thread.currentThread().getName();  
        };  
    };  
  
    public void set() {  
        longLocal.set(Thread.currentThread().getId());  
        stringLocal.set(Thread.currentThread().getName());  
    }  
  
    public long getLong() {  
        return longLocal.get();  
    }  
  
    public String getString() {  
        return stringLocal.get();  
    }  
  
    public static void main(String[] args) throws InterruptedException {  
        final test3 test = new test3();  
  
        //test.set();  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
  
        Thread thread1 = new Thread() {  
            public void run() {  
            	test.stringLocal.set("dicnfjdsdkf");
            	test.stringLocal.remove();
                System.out.println(test.getLong());  
                System.out.println(test.getString());  
            };  
        };  
        thread1.start();  
        thread1.join();  
  
        System.out.println(test.getLong());  
        System.out.println(test.getString());  
    }  
}