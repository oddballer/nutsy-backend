package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.Post;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostsDao implements PostsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPostsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY post_id";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Post post = mapRowToPost(results);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public Post getById(int post_id) {
        Post post = null;
        String sql = "SELECT * FROM posts WHERE post_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, post_id);
        if (results.next()){
            post = mapRowToPost(results);
        }
        return post;
    }

    @Override
    public List<Post> getByUsername(String username) {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts WHERE username = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username);
        while (results.next()){
            Post post = mapRowToPost(results);
            posts.add(post);
        }
        return posts;
    }

    @Override
    public int insert(Post post, String username) {
        String sql = "INSERT INTO posts(username, post_name, ts) VALUES (?, ?, now()) RETURNING post_id";
        int newId = jdbcTemplate.queryForObject(sql, int.class, post.getUsername(), post.getPost_name());

        return newId;
    }

    @Override
    public void update(Post post, String username) {
        String sql = "UPDATE posts SET post_name = ? WHERE post_id = ? AND username = ?";
        jdbcTemplate.update(sql, post.getPost_name(), post.getPost_id(), username);

    }

    @Override
    public void delete(int post_id, String username) {
        String sql = "DELETE FROM post_items WHERE post_id = ? AND username = ?";
        jdbcTemplate.update(sql, post_id, username);
        sql = "DELETE FROM posts WHERE post_id = ? AND username = ?";
        jdbcTemplate.update(sql, post_id, username);

    }

    private Post mapRowToPost(SqlRowSet rowSet){
        Post post = new Post();
        post.setPost_id(rowSet.getInt("post_id"));
        post.setPost_name(rowSet.getString("post_name"));
        post.setUsername(rowSet.getString("username"));
        post.setTs(rowSet.getTimestamp("ts"));
        return post;
    }

}
