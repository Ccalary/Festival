package com.example.caohouhong.festival.bean;

import java.util.Date;

/**
 * Created by caohouhong on 17/5/9.
 */

public class Festival {
    private int id;
    private String name;
    private String desc;
    private Date date;

    public Festival(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


