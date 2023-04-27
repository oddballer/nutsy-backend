package com.nutsy.nutsybackend.model;
import java.sql.Timestamp;

public class PostItem {

    private int post_item_id;
    private int post_id;
    private String username;
    private String content;
    private Timestamp ts;

    public PostItem(int post_item_id, int post_id, String username, String content, Timestamp ts) {
        this.post_item_id = post_item_id;
        this.username = username;
        this.content = content;
        this.ts = ts;
    }

    public PostItem() {

    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getPost_item_id() {
        return post_item_id;
    }

    public void setPost_item_id(int post_item_id) {
        this.post_item_id = post_item_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTs() {
        return ts;
    }

    public void setTs(Timestamp ts) {
        this.ts = ts;
    }
}
