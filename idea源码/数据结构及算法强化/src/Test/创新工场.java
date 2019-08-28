package Test;

import java.util.HashMap;
import java.util.Map;

public class 创新工场 {

    public static void main(String[] args) {
        String a="werew";
        String b="bmmkwwee";
        System.out.println(iscontain(b,a));
    }

    private static boolean iscontain(String b, String a) {
        char[] A=a.toCharArray();
        char[] B = b.toCharArray();

        Map<Character,Integer> mapb=new HashMap<>();
        for (int i=0;i<B.length;i++){
            if (mapb.containsKey(B[i])){
                mapb.put(B[i],mapb.get(B[i])+1);
            }else{
                mapb.put(B[i],1);
            }
        }
        for (int i=0;i<A.length;i++){
            if (mapb.containsKey(A[i])){
                int x = mapb.get(A[i]);
                if (x==1)
                    mapb.remove(A[i]);
                else
                    mapb.put(A[i],x-1);
            }else
                return false;
        }
        return true;
    }
}
