package com.nutsy.nutsybackend.model;
import com.google.type.DateTime;

public class Post {

    private int post_id;
    private String username;
    private String post_name;
    private DateTime ts;

    public Post(int post_id, String username, String post_name, DateTime ts) {
        this.post_id = post_id;
        this.username = username;
        this.post_name = post_name;
        this.ts = ts;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public DateTime getTs() {
        return ts;
    }

    public void setTs(DateTime ts) {
        this.ts = ts;
    }
}
