package com.jason.Config;

import lombok.Data;

import java.util.List;


public class yaml_Inject {

    private String  pen;
    private User user;
    class User {
        String name ;
        int age ;
        List<String> languages;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }
    }

    public String getPen() {
        return pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

}
