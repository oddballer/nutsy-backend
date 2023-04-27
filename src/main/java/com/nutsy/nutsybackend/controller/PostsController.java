package com.nutsy.nutsybackend.controller;

import com.nutsy.nutsybackend.dao.PostItemsDao;
import com.nutsy.nutsybackend.dao.PostsDao;
import com.nutsy.nutsybackend.model.Post;
import com.nutsy.nutsybackend.model.PostItem;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/posts")
@PreAuthorize("isAuthenticated()")
public class PostsController {

    private final PostsDao postsDao;
    private final PostItemsDao postItemsDao;

    public PostsController(PostsDao postsDao, PostItemsDao postItemsDao){
        this.postsDao = postsDao;
        this.postItemsDao = postItemsDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Post> getPosts(){
        List<Post> posts = postsDao.getAll();
        List<PostItem> postItems = postItemsDao.getAll();

        for (Post post : posts){
            for (PostItem postItem : postItems){
                if (postItem.getPost_id() == post.getPost_id()){
                    post.getPostItems().add(postItem);
                }
            }
        }
        return posts;
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post post, Principal principal){
        return postsDao.getById(postsDao.insert(post, principal.getName()));
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public void updatePost(@RequestBody Post post, Principal principal){
        postsDao.update(post, principal.getName());
    }

    @RequestMapping(path = "/delete/{postId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int postId, Principal principal){
        postsDao.delete(postId, principal.getName());
    }

}
