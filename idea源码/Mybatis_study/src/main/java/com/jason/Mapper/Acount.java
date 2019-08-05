package com.jason.Mapper;

import java.io.Serializable;
import java.util.List;

public class Acount implements Serializable {
    private  int id ;
    private  int money;


    private String user;
    private List<User> users;

    public Acount() {
    }

    public Acount(int id) {
        this.id = id;
}

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + id +
                ", money=" + money +
                ", user='" + user + '\'' +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
