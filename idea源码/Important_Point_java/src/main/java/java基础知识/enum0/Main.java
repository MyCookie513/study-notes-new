package java基础知识.enum0;

public class Main {

    public static void main(String[] args) {

        //根据一个枚举类型的字符串返回一个枚举类型
        Color c=Enum.valueOf(Color.class,"RED");
        System.out.println(c.toString());
        //返回所有枚举值的数组
        Color[] colors=Color.values();
        for(Color cc: colors){
            System.out.println(cc.toString()+cc.ordinal());
        }
    }
}
