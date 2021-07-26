package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String name;

  public Category() {
  }

  public Category(long id, String name, List<Ad> ads) {
    this.id = id;
    this.name = name;
    this.ads = ads;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Ad> getAds() {
    return ads;
  }

  public void setAds(List<Ad> ads) {
    this.ads = ads;
  }
//  Were saying there is a many to many relationship with ads
//  The list we grab is a group of ads that have the category

  @ManyToMany(mappedBy = "categories")
  private List<Ad> ads;

}
