package com.nutsy.nutsybackend.model;
import java.sql.Timestamp;


public class Chat {

    private int chat_id;
    private String username;
    private String content;
    private Timestamp ts;

    public Chat(int chat_id, String username, String content, Timestamp ts) {
        this.chat_id = chat_id;
        this.username = username;
        this.content = content;
        this.ts = ts;
    }

    public Chat() {

    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
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
