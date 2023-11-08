package com.oak.JPAexamples.JPAservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQuery(name = "Task.findByTime", query = "SELECT t FROM Task t WHERE t.time > :time")
public class Task {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String name;
    private int time;

}
