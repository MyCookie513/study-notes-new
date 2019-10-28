package 总结一.动态规划.交错字符串;

public class Main {


    public boolean isInterleave(String s1, String s2, String s3) {

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        char[] c3 = s3.toCharArray();

        if (c3.length !=(c1.length +c2.length))
            return false;
        int i1 = 0, i2 = 0, i3 = 0;

        return   trychar(c1,c2,c3,i1,i2,i3);

      }

    private boolean trychar(char[] c1, char[] c2, char[] c3, int i1, int i2, int i3) {

        if (i3==c3.length)
            return true;
        else {
            if (i1>=c1.length){ //todo c1 完活
                if (c2[i2]!=c3[i3])
                    return false;
                return trychar(c1,c2,c3,i1,i2+1,i3+1);
            } else if (i2>=c2.length){ //todo c1 未完 c2 完活
                if (c1[i1]!=c3[i3])
                    return false;
                return trychar(c1,c2,c3,i1+1,i2,i3+1);

            }else{ //todo c1 未完 c2 未完
                if (c1[i1]==c2[i2] ){
                    if (c1[i1]==c3[i3])
                      return trychar(c1,c2,c3,i1+1,i2,i3+1)||trychar(c1,c2,c3,i1,i2+1,i3+1);
                    else return false;
                }else {
                    if (c1[i1]==c3[i3])
                        return trychar(c1,c2,c3,i1+1,i2,i3+1);
                    if (c2[i2]==c3[i3])
                        return trychar(c1,c2,c3,i1,i2+1,i3+1);
                    return false;
                }
            }


        }


    }

}
