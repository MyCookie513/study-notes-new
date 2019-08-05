package com.pojo;
import java.io.Serializable;

public class BookFunEntity implements Serializable {
    private static final long serialVersionUID = -2685579309299885545L;

    private String typeName;    //类型名称
    private int sumber;          //总数
    private double miprice;     //最低价
    private double mxprice;     //最高价
    private double avprice;    //平均价

    public BookFunEntity() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getSumber() {
        return sumber;
    }

    public void setSumber(int sumber) {
        this.sumber = sumber;
    }

    public double getMiprice() {
        return miprice;
    }

    public void setMiprice(double miprice) {
        this.miprice = miprice;
    }

    public double getMxprice() {
        return mxprice;
    }

    public void setMxprice(double mxprice) {
        this.mxprice = mxprice;
    }

    public double getAvprice() {
        return avprice;
    }

    public void setAvprice(double avprice) {
        this.avprice = avprice;
    }
}