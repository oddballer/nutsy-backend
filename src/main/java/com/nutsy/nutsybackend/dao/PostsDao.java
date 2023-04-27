package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.Post;

import java.util.List;

public interface PostsDao {

    List<Post> getAll();

    Post getById(int post_id);

    List<Post> getByUsername(String username);

    int insert(Post post, String username);

    void update(Post post, String username);

    void delete(int post_id, String username);

}
