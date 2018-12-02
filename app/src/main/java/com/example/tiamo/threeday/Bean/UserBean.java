package com.example.tiamo.threeday.Bean;

public class UserBean {

    private String title;
    private String uuid;

    public UserBean(String title, String uuid) {
        this.title = title;
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
