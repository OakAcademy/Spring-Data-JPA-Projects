package com.oak.JPAexamples.JPAservice.Repositories;

import com.oak.JPAexamples.JPAservice.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByTime(@Param("time") Integer time);
}
