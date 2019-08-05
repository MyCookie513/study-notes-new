package 高并发第二阶段;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str="http://sysadmin:123456@10.15.15.89:8090/ demo/testWar.git";

        Pattern p= Pattern.compile("\\d*.\\d{1,3}.\\d{1,3}.\\d{1,3}:\\d*/.*/.*");
        //Pattern ps=Pattern.compile("1[3,8,7,9]\\d{9}");
        Matcher m=p.matcher(str.toString());
        while(m.find()) {
        	 /*if(p.matcher(m.group().toString()).matches()
        		) {*/
            System.out.println("合法："+m.group());
            //}

            System.out.println("http://" +m.group().toString());
        }
    }
}
