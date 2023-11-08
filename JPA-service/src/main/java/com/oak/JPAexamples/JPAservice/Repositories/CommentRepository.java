package com.oak.JPAexamples.JPAservice.Repositories;

import com.oak.JPAexamples.JPAservice.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
