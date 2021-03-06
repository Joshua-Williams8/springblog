package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//We can also direct this to write to our database.
@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false, length = 200)
  private String body;

  @ManyToOne
  @JoinColumn(name = "commenter_id")
  private User commenter;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  public Comment(){

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public User getCommenter() {
    return commenter;
  }

  public void setCommenter(User commenter) {
    this.commenter = commenter;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}
