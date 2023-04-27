package com.nutsy.nutsybackend.model;
import com.google.type.DateTime;

public class PostItem {

    private int post_item_id;
    private String username;
    private String content;
    private DateTime ts;

    public PostItem(int post_item_id, String username, String content, DateTime ts) {
        this.post_item_id = post_item_id;
        this.username = username;
        this.content = content;
        this.ts = ts;
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

    public DateTime getTs() {
        return ts;
    }

    public void setTs(DateTime ts) {
        this.ts = ts;
    }
}
