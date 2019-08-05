package 线段树;
import java.util.Arrays;
import java.util.Scanner;
public class 遍历比较最普通的做法 {


        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            while(scan.hasNext()) {

                String s="";

                int num=scan.nextInt();
                int[] a=new int[num];

                int caozuo=scan.nextInt();

                for(int i=0;i<num;i++) {

                    a[i]=scan.nextInt();

                }


                for(int i=0;i<caozuo;i++) {

                    String  c=scan.next();
                    int k=scan.nextInt();
                    int h=scan.nextInt();
                    ff(c,k,h ,a);




                }
            }
        }

        static void  ff(String  c,int k,int h,int[]  a) {


            if(c.equals("Q")) {

                int z = 0;
                if(k<h)
                    for(int i=k-1;i<h;i++) {
                        if(z<a[i]) {
                            z=a[i];
                        }


                    }
                else
                    for(int i=h-1;i<k;i++) {
                        if(z<a[i]) {
                            z=a[i];
                        }


                    }
                System.out.println(z);



            }else if(c.equals("U")){


                a[k-1]=h;


            }








        }





}
