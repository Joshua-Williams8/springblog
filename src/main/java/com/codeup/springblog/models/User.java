package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

//We can also direct this to write to our database.
@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;



  //  Below sets up the parameters for our column
  @Column(nullable = false, length = 25)
  private String username;
  //  All of our columns in here are going to transfer into the database.
  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;
//  Below says 1 user to many of this...
//  Cascade is when the user gets deleted, all of it's asscioated ads would also get deleted.
//  We are then mapping this under the user
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Ad> ads;
//  Above is now a reference to all the post the user should have associated with it?
//  We established that the user wants to be associated with the ads.

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private List<Post> post;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "commenter")
  private List<Comment> comments;

  public List<Post> getPost() {
    return post;
  }



  public User(long id, String username, String email, String password, List<Ad> ads, List<Post> post) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.ads = ads;
    this.post = post;
  }

  public void setPost(List<Post> post) {
    this.post = post;
  }

  public User(long id, String username, String email, String password, List<Post> post) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.post = post;
  }

  public List<Ad> getAds() {
    return ads;
  }

  public void setAds(List<Ad> ads) {
    this.ads = ads;
  }

  public User() {
  }
//  Create a new object by copying just the values, not the actual object refernece
  public User(User copy){
    id = copy.id;
    email = copy.email;
    username = copy.username;
    password = copy.password;
    ads = copy.ads;
    post = copy.post;
  }

  public User(long id, String username, String email, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
