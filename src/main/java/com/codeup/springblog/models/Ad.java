package com.codeup.springblog.models;

import javax.persistence.*;

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
