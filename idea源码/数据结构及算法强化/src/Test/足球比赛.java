package Test;

import java.util.Scanner;

public class 足球比赛 {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for (int i=0;i<t;i++){
            int zong=sc.nextInt();
            int had=sc.nextInt();
            int AB=sc.nextInt();
            int BC=sc.nextInt();
            boolean y=false;
            int h=0;
            if ((h=(had-AB-BC))%3==0&&h/3>=0){
                int z;
                if (AB>BC)
                    z=AB+AB-BC;
                else
                    z=BC+BC-AB;

                int kexiaohao=zong-had;
                if ((kexiaohao-z)>=0 && (kexiaohao-z)%3==0){
                    y=true;

                }
            }
            if ((h=(had+AB+BC))%3==0 &&(h/3-AB)>=0 && (h/3-BC)>=0 ){
                int z=AB+BC;
                int kexiaohao=zong-had;
                if ((kexiaohao-z)>=0 && (kexiaohao-z)%3==0){
                    y=true;

                }
            }

            if (((h=(had-AB+BC))%3)==0 && h/3-BC>0){
                    int z= AB+AB+BC;
                int kexiaohao=zong-had;
                if ((kexiaohao-z)>=0 && (kexiaohao-z)%3==0){
                    y=true;

                }
                }
            if (((h=(had+AB-BC))%3)==0 && h/3-AB>0){
                    int z=BC+BC+AB;
                int kexiaohao=zong-had;
                if ((kexiaohao-z)>=0 && (kexiaohao-z)%3==0){
                    y=true;

                }
            }
            if (y==true)
                System.out.println("yes");
            else
                System.out.println("no");

        }
    }

    private static void valtify(int z,int kexiaohao,boolean y) {

        if ((kexiaohao-z)>=0 && (kexiaohao-z)%3==0){
            y=true;

        }

    }
}
