package 总结一.动态规划.交错字符串;

public class Solution {





    public boolean isInterleave(String s1, String s2, String s3) {

        char[] c1=s1.toCharArray();
        char[] c2=s2.toCharArray();

        char[] c3=s3.toCharArray();

        int i1=0,i2=0,i3=0;

        int tag1 = 0,tag2 = 0;
        boolean b=true; //todo 是否是确定的匹配；

        while (i3<c3.length){

            if (i1>=c1.length){ //todo i1 越界，i2 未知
                if (i2>=c2.length)
                    return false;
                if (c3[i3]==c2[i2]){
                    i3++;
                    i2++;
                    if (!b) {
                        i1=tag1;
                    }
                }else {
                    return false;
                }

            }else if (i2>=c2.length){ //todo i1没有越界 ，i2 越界
                if (c3[i3]==c1[i1]){
                    i3++;
                    if (!b) {
                        i2=tag2;
                    }
                    i1++;
                }else {
                    return false;
                }

            }else{ //todo i1 ,i2 都没越界了

                if (c1[i1]==c2[i2]){
                    if (c1[i1]!=c3[i3]){
                        return false;
                    }
                    tag1=i1;
                    tag2=i2;
                    b=false;
                    i1++;i2++;i3++;

                }else{
                    if (c1[i1]==c3[i3]){
                        if (!b){
                            i2=tag2;
                            b=true;
                        }
                        i1++;

                    }else if (c3[i3]==c2[i2]){
                        if (!b){
                            i1=tag1;
                            b=true;
                        }
                        i2++;
                    }else{
                        return false;
                    }
                    i3++;
                }

            }


            System.out.println("i1: "+i1 +"     i2 : "+"   i3: "+i3);
        }

        if (i2!=c2.length || i1!=c1.length)
            return false;
        return true;

    }




}
