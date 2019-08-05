package com.jason.Mapper;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private int idt_user;
    private int t_usercol;
    private String t_username;
    private String t_password;
    private Date date;
    private Status status=Status.LOGIN;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User(int idt_user, int t_usercol, String t_username, String t_password, Date date, Acount acount) {
        this.idt_user = idt_user;
        this.t_usercol = t_usercol;
        this.t_username = t_username;
        this.t_password = t_password;
        this.date = date;
        this.acount = acount;
    }

    public User() {
    }

    public User(int t_usercol, String t_username, String t_password, Date date, Acount acount) {

        this.t_usercol = t_usercol;
        this.t_username = t_username;
        this.t_password = t_password;
        this.date = date;
        this.acount = acount;
    }

    private Acount acount;

    public Acount getAcount() {
        return acount;
    }

    public void setAcount(Acount acount) {
        this.acount = acount;
    }

    public int getIdt_user() {
        return idt_user;
    }

    public void setIdt_user(int idt_user) {
        this.idt_user = idt_user;
    }

    public int getT_usercol() {
        return t_usercol;
    }

    public void setT_usercol(int t_usercol) {
        this.t_usercol = t_usercol;
    }

    public String getT_username() {
        return t_username;
    }

    public void setT_username(String t_username) {
        this.t_username = t_username;
    }

    public String getT_password() {
        return t_password;
    }

    public void setT_password(String t_password) {
        this.t_password = t_password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "idt_user=" + idt_user +
                ", t_usercol=" + t_usercol +
                ", t_username='" + t_username + '\'' +
                ", t_password='" + t_password + '\'' +
                ", date=" + date +
                '}';
    }



}
