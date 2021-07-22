package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

  public List<Post> postsList = new ArrayList<Post>(){{
    add( new Post(1,"Title 1", "Stuff for body 1"));
    add(new Post(2,"2nd title", "Stuff for 2nd body."));
  }};


  @GetMapping("/posts")
  public String posts(Model model){
    model.addAttribute("postsList", postsList);
    return "posts/index";
  }

  @GetMapping("/posts/{id}")
  public String postByID(@PathVariable long id, Model model){
    int minusOne = (int) id - 1;
    Post post = postsList.get(minusOne);
    model.addAttribute("post", post);
    return "posts/show";
  }

  @RequestMapping(path ="/posts/create", method = RequestMethod.GET)
  @ResponseBody
  public String postCreateGet(){
    return "This is the Create Post Page. From displayed here?";
  }

  @RequestMapping(path ="/posts/create", method = RequestMethod.POST)
  @ResponseBody
  public String postCreatePost(){
    return "This is POSTING or creating the post? Form sent here?";
  }




}
