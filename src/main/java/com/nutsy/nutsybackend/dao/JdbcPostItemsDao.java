package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.PostItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostItemsDao implements PostItemsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostItemsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<PostItem> getAll() {
        List<PostItem> postItems = new ArrayList<>();
        String sql = "SELECT * FROM post_items";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            PostItem postItem = mapRowFromPostItem(results);
            postItems.add(postItem);
        }
        return postItems;
    }

    @Override
    public List<PostItem> getItemsByPostId(int postId) {
        List<PostItem> postItems = new ArrayList<>();
        String sql = "SELECT * FROM post_items WHERE post_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, postId);
        while (results.next()){
            PostItem postItem = mapRowFromPostItem(results);
            postItems.add(postItem);
        }
        return postItems;
    }

    private PostItem mapRowFromPostItem (SqlRowSet rowSet){
        PostItem postItem = new PostItem();
        postItem.setPost_item_id(rowSet.getInt("post_item_id"));
        postItem.setPost_id(rowSet.getInt("post_id"));
        postItem.setUsername(rowSet.getString("username"));
        postItem.setContent(rowSet.getString("content"));
        postItem.setTs(rowSet.getTimestamp("ts"));

        return postItem;
    }
}
