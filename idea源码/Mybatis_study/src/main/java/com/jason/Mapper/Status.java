package com.jason.Mapper;

public enum Status {
    LOGIN(100,"用户登陆"),LOGINOUT(200,"用户离开"),REMOVE(300,"用户删除");

    private Integer code ;
    private String msg;

    public static  Status getStatus(Integer code ){
        switch (code){
            case 100: return LOGIN;
            case 200: return LOGINOUT;
            case 300: return REMOVE;
            default: return LOGIN;
        }
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    Status(int i, String info) {
       code =i;
       msg=info;
    }


   /* static  Status getStatusBycode (Integer code ){

    }*/
}
