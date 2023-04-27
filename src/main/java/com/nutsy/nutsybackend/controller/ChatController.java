package com.nutsy.nutsybackend.controller;

import com.nutsy.nutsybackend.dao.ChatsDao;
import com.nutsy.nutsybackend.model.Chat;
import com.nutsy.nutsybackend.model.Post;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/chat")
@PreAuthorize("isAuthenticated()")
public class ChatController {

private final ChatsDao chatsDao;

    public ChatController(ChatsDao chatsDao) {
        this.chatsDao = chatsDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Chat> getChats(){
        return chatsDao.getAll();
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public List<Chat> addChat(@RequestBody Chat chat, Principal principal){
        chatsDao.insert(chat, principal.getName());
        return chatsDao.getAll();
    }
}
