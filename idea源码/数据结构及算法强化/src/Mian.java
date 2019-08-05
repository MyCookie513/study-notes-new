import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mian {


    public static void main(String[] args) {
        List<Character> list=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        int[] a=new int[10];
        int x=sc.nextInt();
        for(int i=0;i<x;i++){
            char[] c=sc.next().toCharArray();
            for(int j=0;j<c.length;j++){
                a[c[j]-'0']++;

            }

        }
        for(int i=9;i>=0;i--){
            for(int j=1;j<=a[i];j++){
                System.out.print(i);
            }
        }
    }








/*
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int a=str.lastIndexOf(" ");

        System.out.println(str.length()-1-a);
    }*/







}
