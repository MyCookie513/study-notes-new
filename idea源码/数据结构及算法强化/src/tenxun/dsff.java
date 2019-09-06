package tenxun;

import java.util.Scanner;

public class dsff {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a=new int[n] ;
        int min_index=0;
        int min;
        int s=0,e=n-1;
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Re re=new Re();
        digui(a,re,0,n-1);
        System.out.println(re.re);
    }

    private static void digui(int[] a, Re re,int s,int e) {

        Obj obj= jisuan(s,e,a);
            if (obj.he>re.re)
                re.re=obj.he;
        if (obj.min_index-1>=s){
            digui(a,re,0,obj.min_index-1);
        }
        if (obj.min_index+1<=e){
            digui(a,re,obj.min_index+1,a.length-1);
        }
    }

    private static Obj jisuan(int s, int e, int[] a) {

        int he =0;
        int min =Integer.MAX_VALUE;
        int index=0;
        for (int i=s;i<=e;i++){
            he+=a[i];
           if (a[i]<min)
               index=i;
        }

        return new Obj(index,he);
    }

   static class Obj{
        int min_index;
        int he ;

        public Obj(int min_index, int he) {
            this.min_index = min_index;
            this.he = he;
        }
    }

    static class Re{
        int re;


    }
}
