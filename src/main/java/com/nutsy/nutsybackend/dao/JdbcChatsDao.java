package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.Chat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcChatsDao implements ChatsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcChatsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Chat> getAll() {
        List<Chat> chats = new ArrayList<>();
        String sql = "SELECT * FROM chats ORDER BY chat_id DESC;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Chat chat = mapRowToChat(results);
            chats.add(chat);
        }
        return chats;
    }

    @Override
    public void insert(Chat chat, String username) {
        String sql = "INSERT INTO chats(username, content, ts) VALUES (?, ?, now())";
        jdbcTemplate.update(sql, username, chat.getContent());

    }

    private Chat mapRowToChat(SqlRowSet rowSet){
        Chat chat = new Chat();
        chat.setChat_id(rowSet.getInt("chat_id"));
        chat.setUsername(rowSet.getString("username"));
        chat.setContent(rowSet.getString("content"));
        chat.setTs(rowSet.getTimestamp("ts"));
        return chat;
    }

}
