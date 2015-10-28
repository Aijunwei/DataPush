package com.common.tool;

/**
 * Created by C2-41 on 15-10-28.
 */
public class User {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long id;
    private String name;
    public User(long id,String name){
        this.id=id;
        this.name=name;
    }

}
