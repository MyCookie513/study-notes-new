package Random;

import java.util.Random;

/**
 * random7-》10 利用数组形式的进行扩容哦；
 *
 */
public class rand7__rand10 {
    private Random random=new Random(System.currentTimeMillis());
    private static int rand7(){
        return 5;
    }
    public static int rand10() {
        //array
        int[][] a=new int[2][5];
        int x0=1;
        for(int i=0;i<2;i++){
            for(int j=0;j<5;j++){
                a[i][j]=x0++;
            }
        }
        int x=0;int y=0;
        while(true){
            x=rand7();
            if(x<4){
                x=0;
                break;
            }else if(x>4){
                x=1;
                break;
            }

        }
        while(true){
            y=rand7();
            if(y<6)
                break;
        }
        return a[x][y-1];
    }

    public static void main(String[] args) {
        System.out.println(rand10());
    }
}
