package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

  @RequestMapping(path ="/posts", method = RequestMethod.GET)
  @ResponseBody
  public String posts(){
    return "POST INDEX PAGE (Would have post here)";
  }

  @RequestMapping(path ="/posts/{id}", method = RequestMethod.GET)
  @ResponseBody
  public String postByID(@PathVariable long id){
    return "This page is for post ID: "+id;
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
