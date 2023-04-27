package com.nutsy.nutsybackend.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class Post {

    private int post_id;
    private String username;
    private String post_name;
    private Timestamp ts;
    private List<PostItem> postItems = new ArrayList<>();

    public Post(int post_id, String username, String post_name, Timestamp ts) {
        this.post_id = post_id;
        this.username = username;
        this.post_name = post_name;
        this.ts = ts;
    }

    public Post() {

    }

    public List<PostItem> getPostItems() {
        return postItems;
    }

    public void setPostItems(List<PostItem> postItems) {
        this.postItems = postItems;
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

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
