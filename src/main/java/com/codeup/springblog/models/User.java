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
//  This ID is going to be the MAIN identifier, that is in this class.
//  Database understands it will be auto incremented inside of mysql.

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

  public List<Ad> getAds() {
    return ads;
  }

  public void setAds(List<Ad> ads) {
    this.ads = ads;
  }

  public User() {
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
