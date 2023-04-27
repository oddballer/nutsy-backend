package com.nutsy.nutsybackend.dao;

import com.nutsy.nutsybackend.model.User;
import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    User create(User newUser);
}
