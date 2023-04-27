package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.Chat;

import java.security.Principal;
import java.util.List;

public interface ChatsDao {

    List<Chat> getAll();

    void insert(Chat chat, String username);

}
