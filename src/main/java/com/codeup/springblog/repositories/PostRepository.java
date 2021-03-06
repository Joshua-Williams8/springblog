package com.codeup.springblog.repositories;

import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Query("from Post a where a.id = ?1")
  Post findById(long id);

  @Query("from Post a where a.title like %:title%")
  List<Post> findAllByTitle(String title);

  @Query("from Post a where a.title like %:term%")
  Post findFirstByTitle(String term);

  void deleteById(long id);

  @Query("from Post a where a.title like %:term%")
  Post findByTitle(String term);


}


