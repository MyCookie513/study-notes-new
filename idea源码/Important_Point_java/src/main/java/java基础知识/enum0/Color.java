package java基础知识.enum0;

public enum Color {

    RED("RED", 1), VIOLET("VIOLET", 2), BLANK("BLUE", 3), YELLO("YELLOW", 4);
    // 成员变量
    private String name;
    private int index;

    //自动调用这个进行赋值
    Color(String color, int i) {
        name=color;
        index=i;
    }
    //返回枚举类的常量名；
    public String getsomething(Color color){
        switch (color) {
            case RED:
                color = Color.RED;
                break;
            case VIOLET:
                color = Color.VIOLET;
                break;
            case BLANK:
                color = Color.BLANK;
                break;
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
