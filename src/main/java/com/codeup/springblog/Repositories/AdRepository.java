package com.codeup.springblog.Repositories;

import com.codeup.springblog.models.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//This is going to be taking the place of our DAOs.
//Look up JPA respository methods for later?
public interface AdRepository extends JpaRepository<Ad, Long> {

  @Query("from Ad a where a.id = ?1")
  Ad findById(long id);

  @Query("from Ad a where a.title like %:term%")
  Ad findFirstByTitle(String term);


}
