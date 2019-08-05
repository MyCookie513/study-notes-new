package ThreadPool;
import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) {


    }






    public static void  split(String src ,int filesize ,String dest  ){

        File file =new File(src);

        long srcsize =file.length();
        if(srcsize<=500*1024*1024)
            return;
        long destsize=1024*1024*filesize;
        int number=(int) (srcsize/destsize);
        number =srcsize%destsize==0?number:number+1;


        String filename=src.substring(src.lastIndexOf("\\"));
        InputStream in=null;
        BufferedInputStream bis=null;
        byte[] bytes=new byte[1024*1024];
        int len=-1;

        try {
            in=new FileInputStream(file);
            bis=new BufferedInputStream(in);
//自定义线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 200, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.DiscardPolicy());
            for(int i=0;i<number;i++){

                String destname =dest+File.separator+filename+"-"+i+".bat";
                OutputStream out=new FileOutputStream(destname);
                BufferedOutputStream bos =new BufferedOutputStream(out);
                int count =0;
                while((len=bis.read(bytes))!=-1){

                    bos.write(bytes,0,len);
                    count+=len;
                    if(count>=destsize)
                        break;
                }

                bos.flush();
                bos.close();
                out.close();



                executor.execute(()->{
                    split(destname,500,"目的地址");
                });




            }
            executor.shutdown();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

