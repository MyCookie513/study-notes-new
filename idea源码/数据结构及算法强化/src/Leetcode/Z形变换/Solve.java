package Leetcode.Z形变换;

public class Solve {


    public static void main(String[] args) {

      /*  System.out.println(Integer.MAX_VALUE);
        System.out.println(convert("PAYPALISHIRING"

                ,3));*/
        System.out.println(myAtoi(" "));
    }
    public static String convert(String s, int numRows) {
        if(s.equals("")||s==null||s.length()==1||numRows==1)
            return s;

        int  len=s.length();
        char[] c=s.toCharArray();
        char[][] r=new char[numRows][(numRows-1)*((len/(2*numRows-2))+1)];

        int x=0;
        int lie=0;
        while (x<len){
            int hang=0;
            while (hang<numRows&&x<len){
                r[hang][lie]=c[x];
                x++;
                hang++;
            }

            hang-=2;lie++;
            while (hang>0&&x<len){
                r[hang][lie]=c[x];
                x++; hang--; lie++;
            }
        }

        StringBuilder stringBuilder=new StringBuilder("");
        for (int i=0;i<numRows;i++){
            for (int j=0;j<r[0].length;j++){


                if (r[i][j]!=0){
                    stringBuilder.append(r[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String convertf(String s, int numRows) {
        if(s.equals("")||s==null||s.length()==1||numRows==1)
            return s;
        StringBuilder[] stringBuilders=new StringBuilder[numRows];
        for (int i=0;i<stringBuilders.length;i++){
            stringBuilders[i]=new StringBuilder();
        }
        char[] a=s.toCharArray();
        int i=0;int x=1;
        for (int j=0;i<s.length();i++,j=j+x){
            if (j==0)
                x=1;
            else if (j==numRows-1)
                x=-1;
            stringBuilders[j].append(a[i]);
        }
        StringBuilder r=new StringBuilder();
        for (int l=0;l<stringBuilders.length;l++){
            r.append(stringBuilders[l].toString());
        }
        return r.toString();
    }



    public static int reverse(int x) {


        StringBuffer stringBuilder=new StringBuffer(String.valueOf(x>=0?x:-x));

        try {
            int a=Integer.parseInt((x>=0? "":"-") +stringBuilder.reverse().toString());
            return a;
        }
        catch (Exception e){
            return 0;
        }
    }


    public static int myAtoi(String str) {
        if (str==null)
            return  0;
        String str0=str.trim();
        if (str0.equals(""))
            return 0;
        char[] a=str0.toCharArray();
        String prefix="";

        if(a[0]=='-'||a[0]=='+'){
            prefix=prefix+a[0];
        } else if(a[0]<'0' || a[0]>'9')
            return 0;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<a.length;i++){
            if (i==0&& (a[i]=='-'||a[i]=='+'))
                continue;
            if(a[i]>='0' && a[i]<='9')
                stringBuilder.append(a[i]);
            else
                break;

        }
        if (stringBuilder.length()==0)
            return 0;
        else{
            try {
                int k=Integer.parseInt(prefix+stringBuilder.toString());
                return k;
            }
            catch (Exception e){
                if (prefix.equals("-"))
                    return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }
        }

    }

}
