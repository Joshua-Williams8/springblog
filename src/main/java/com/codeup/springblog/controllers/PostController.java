package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.Repositories.PostRepository;
import com.codeup.springblog.Repositories.UserRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateInputException;

import javax.persistence.EntityNotFoundException;


@Controller
public class PostController {
  private final PostRepository postDao;
  private final UserRepository userDao;
  private final EmailService emailSvc;


  public PostController(PostRepository postDao, UserRepository userDao, EmailService emailSvc) {
    this.postDao = postDao;
    this.userDao = userDao;
    this.emailSvc = emailSvc;
  }

//  public List<Post> postsList = new ArrayList<Post>(){{
//    add( new Post(1,"Title 1", "Stuff for body 1"));
//    add(new Post(2,"2nd title", "Stuff for 2nd body."));
//  }};


  @GetMapping("/posts")
  public String showPosts(Model model) {
    model.addAttribute("postsList", postDao.findAll());

//    model.addAttribute("postsList", postsList);
    return "posts/index";
  }

//  @PostMapping("/posts")
//  public String showPostsPost(Model model) {
//    model.addAttribute("postsList", postDao.findAll());
//
////    model.addAttribute("postsList", postsList);
//    return "posts/index";
//  }

  @GetMapping("/posts/{id}")
  public String postByID(@PathVariable long id, Model model) {
//    int minusOne = (int) id - 1;
//    Post post = postsList.get(minusOne);
    try {
      Post post = postDao.findById(id);
      boolean isPostOwner = false;

      if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() != "anonymousUser") {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        isPostOwner = currentUser.getId() == post.getUser().getId();
      }
      model.addAttribute("isPostOwner", isPostOwner);
      model.addAttribute("post", post);
      return "posts/show";
    } catch (Exception e){
      e.printStackTrace();
      return "redirect:posts/";
    }
  }

//  @PostMapping("/join")
//  public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
//    model.addAttribute("cohort", "Welcome to " + cohort + "!");
//    return "join";
//  }
//The parameter needs to be the same name on the variable!
  @GetMapping("/posts/{id}/edit")
  public String postEditGet(@PathVariable long id, Model model) {
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser") {
      return "redirect:/posts/" + id;
    }
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Post post = postDao.findById(id);
//    We grab the current user, with the secturity context holder, and test to see if the IDs match because showing the edit page.
    if(currentUser.getId() == post.getUser().getId()) {
      model.addAttribute("post", post);
      return "posts/edit";
    } else {
      return "redirect:/posts/" + id;
    }

  }

//  @PostMapping("/posts/{id}/edit")
//  public String postEditPost(@PathVariable long id, @RequestParam(name = "newTitle") String newTitle, @RequestParam(name = "newBody") String newBody, Model model) {
//    Post post = postDao.findById(id);
//    post.setTitle(newTitle);
//    post.setBody(newBody);
//    postDao.save(post);
//    model.addAttribute("post",post);
//    return "posts/edit";
//  }

  @PostMapping("/posts/{id}/edit")
  public String postEditPost(@PathVariable long id,@ModelAttribute Post post) {
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    post.setUser(userDao.findById(currentUser.getId()));
    postDao.save(post);
    return "redirect:/posts/" + id;
  }

  @PostMapping("/posts/delete")
//    @PostMapping("/posts/delete/{id}")
  public String postEditDelete(@RequestParam(name = "postId") String postId, Model model) {
    long postIdLong = Long.parseLong(postId);
    postDao.deleteById(postIdLong);

//     You can also do below
//    Post post = postDao.getById(postIdLong);
//    postDao.delete(post);
//    System.out.println(post.getTitle());
//    System.out.println(postModel.getTitle());
//    Post postEdit1 = post;
//    Post postEdit2 = postModel;
//    model.addAttribute("postEdit", post);
    model.addAttribute("postsList", postDao.findAll());
    return "posts/index";
//    return "redirect:/posts"
  }

  @GetMapping("/posts/create")
  public String postCreateGet(Model model) {
    if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() == "anonymousUser") {
      return "redirect:/posts";
    }
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//    We grab the current user, with the secturity context holder, and test to see if the IDs match because showing the edit page.

    model.addAttribute("post", new Post());
    return "posts/create";
  }



  @PostMapping("/posts/create")
  public String postCreatePost(@ModelAttribute Post post){

    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    post.setUser(userDao.findById(currentUser.getId()));
    postDao.save(post);
//    \n does create a new line in the email!
    emailSvc.prepareAndSend(post.getUser().getEmail(), "New post Created!", "Post title: " + post.getTitle() + "\nPost body: " + post.getBody());
    return "redirect:/posts";
  }


}
