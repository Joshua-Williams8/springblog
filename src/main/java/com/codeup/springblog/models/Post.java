package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 155)
//  @NotBlank(message = "Post need a title!")
//  @Size(min = 3, message = "A title must be at least 3 characters!")
  private String title;


  @Column(nullable = false)
//  @NotBlank(message = "Post need a body!")
//  @Size(max = 255, message = "The max size is 255 characters!")
  private String body;

  // Establishes that there's going to be multiple ads tied back to One user.
  // Join column binds the relationship together?
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Post(long id, String title, String body, User user) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.user = user;
  }


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  public Post(long id, String title, String body) {
    this.title = title;
    this.body = body;
    this.id = id;
  }

  public Post() {

  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
