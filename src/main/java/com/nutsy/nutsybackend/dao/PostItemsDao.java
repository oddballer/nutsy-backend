package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.PostItem;

import java.util.List;

public interface PostItemsDao {

    List<PostItem> getAll();

    List<PostItem> getItemsByPostId(int postId);



}
