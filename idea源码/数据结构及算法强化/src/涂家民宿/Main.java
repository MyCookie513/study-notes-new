package 涂家民宿;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int mofa =sc.nextInt();

        int S=sc.nextInt();
        int ss=S;


        int T=sc.nextInt();



        int t0=0;
        boolean b=false;
        while(true){
            if (mofa<10 ){
               // System.out.println(mofa);
                int t=(10-mofa)/4;
                if ((10-mofa)%4!=0)
                    t++;
                t++;

                if (t0+t>T)
                    break;
                else{

                    t0+=t;
                    mofa+=(t-1)*4-10;
                    S-=50;
                    if (S<=0){
                        b=true;
                        break;
                    }

                }
            }else {

                mofa-=10;
                S-=50;
                t0++;
                if (t0>=T ){
                    break;
                }
                if (S<=0){
                    b=true;
                    break;
                }

            }
        }


        while (t0<T && b==false){

            t0++;
            S-=13;
            if (S<=0)
                b=true;
        }


        if (b==true){
            System.out.println("Yes "+t0);
        }else {
            System.out.println("No "+ (ss-S));
        }

    }
}
