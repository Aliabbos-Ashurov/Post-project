package com.abbos.postproject.repository;

import com.abbos.postproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Aliabbos Ashurov
 * @since 19/November/2024  17:32
 **/
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post p WHERE  p.id = :id")
    Post findByIdCustom(@Param("id") Long id);

    @Modifying
    @Query("update Post p SET p.deleted = TRUE WHERE p.id = :id")
    void softDelete(@Param("id") Long id);

    Long id(Long id);
}
