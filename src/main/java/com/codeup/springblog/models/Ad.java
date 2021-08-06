package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//We can also direct this to write to our database.
@Entity
@Table(name="ads")
public class Ad {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
//  This ID is going to be the MAIN identifier, that is in this class.
//  Database understands it will be auto incremented inside of mysql.

//  Below sets up the parameters for our column
  @Column(nullable = false, length = 150)
  private String title;
//  All of our columns in here are going to transfer into the database.
  @Column(nullable = false)
  private String description;
//  Below sets 1 adImage to 1 ad?
  @OneToOne
  private AdImage adImage;


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Ad(long id, String title, String description, User user) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.user = user;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setDate(int year, int month, int day){

  }

  // Establishes that there's going to be multiple ads tied back to One user.
  // Join column binds the relationship together?
  @ManyToOne
  @JoinColumn(name="user_id")
  private User user;

//  We are able to point back at all the categories for our ad, and list them.

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
    name = "ads_categories",
    joinColumns = {@JoinColumn(name ="ad_id")},
    inverseJoinColumns = {@JoinColumn(name="category_id")}
  )
  private List<Category> categories;


  @Column
  @Temporal(TemporalType.DATE)
  @JsonFormat(pattern="yyyy-MM-dd")
  private Date date;

  public Ad(long id, String title, String description, AdImage adImage, Date date) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.adImage = adImage;
    this.date = date;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
  }

  public Ad(long id, String title, String description, AdImage adImage, User user, List<Category> categories) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.adImage = adImage;
    this.user = user;
    this.categories = categories;
  }

  public Ad(long id, String title, String description, AdImage adImage) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.adImage = adImage;
  }

  public AdImage getAdImage() {
    return adImage;
  }

  public void setAdImage(AdImage adImage) {
    this.adImage = adImage;
  }

  public Ad(long id, String title, String description) {
    this.id = id;
    this.title = title;
    this.description = description;
  }

  public Ad() {

  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
