package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
  private final PostRepository postDao;
  private UserRepository userDao;

  public PostController(PostRepository postDao, UserRepository userDao) {
    this.postDao = postDao;
    this.userDao = userDao;
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
    Post post = postDao.findById(id);
    model.addAttribute("post", post);
    return "posts/show";
  }

//  @PostMapping("/join")
//  public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
//    model.addAttribute("cohort", "Welcome to " + cohort + "!");
//    return "join";
//  }

  @PostMapping("/posts/edit")
//  @PostMapping("/posts/edit/{id}")
//    public String postEditGet(@PathVariable long postId, Model model) {
  public String postEditGet(@RequestParam(name = "postId") long postId, Model model) {
//    long postIdLong = Long.parseLong(postId);
    Post post = postDao.getById(postId);
//    System.out.println(post.getTitle());
//    System.out.println(postModel.getTitle());
//    Post postEdit1 = post;
//    Post postEdit2 = postModel;
    model.addAttribute("postEdit", post);
    return "posts/edit";
  }

  @PostMapping("/posts/edit/submit")
  public String postEditSubmit(@RequestParam(name = "postId") String postId, @RequestParam(name = "newTitle") String newTitle, @RequestParam(name = "newBody") String newBody, Model model) {
    long postIdLong = Long.parseLong(postId);
    Post post = new Post(postIdLong, newTitle, newBody);
    postDao.save(post);
//    System.out.println(post.getTitle());
//    System.out.println(postModel.getTitle());
//    Post postEdit1 = post;
//    Post postEdit2 = postModel;
    Post updatedPost = postDao.findById(postIdLong);
    model.addAttribute("postEdit", updatedPost);
    return "posts/edit";
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
  public String postCreateGet() {
    return "posts/new";
  }

  @PostMapping("/posts/create/test")
  public String postCreatePostTest(@RequestParam(name = "userId") long userId,Model model) {
    User creatorTest = userDao.getById(1L);
    String testTitle = "New post Title";
    String testBody = "Body body bdoy body bdoy dbdyoyoby";
    Post newPost = new Post(testTitle,testBody, creatorTest);
    postDao.save(newPost);
    return "posts/index";
  }

  @RequestMapping(path = "/posts/create/submit", method = RequestMethod.POST)
  @ResponseBody
  public String postCreatePost(
    @RequestParam(name = "userId") long userId,
    @RequestParam(name = "postTitle") String postTitle,
    @RequestParam(name = "postBody") String postBody,
    Model model) {
    User creatorTest = userDao.getById(1L);
    User creator = userDao.getById(userId);
    Post newPost = new Post(postTitle,postBody, creatorTest);
    postDao.save(newPost);
    return "posts/index";
  }


}
