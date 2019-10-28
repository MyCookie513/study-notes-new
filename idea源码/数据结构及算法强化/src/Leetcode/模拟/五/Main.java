package Leetcode.模拟.五;

public class Main {

    public boolean canThreePartsEqualSum(int[] A) {

        int num=0;
        for (int i = 0; i < A.length; i++) {
            num =num+ A[i];
        }

        if (num%3!=0)
            return false;

        int a=num/3;

        System.out.println(a+"  "+num);
        int x=0,j=0;
        for (int i = 0; i < A.length; i++) {
            x =x+ A[i];
            if (x== a){
                x=0;j++;
            }else if (x>a){
                return false;
            }
        }
        if (x==0 && j==3)
            return true;
        return false;


    }




}
