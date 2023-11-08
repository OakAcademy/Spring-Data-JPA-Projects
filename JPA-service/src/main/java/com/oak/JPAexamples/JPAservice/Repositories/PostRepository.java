package com.oak.JPAexamples.JPAservice.Repositories;

import com.oak.JPAexamples.JPAservice.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
