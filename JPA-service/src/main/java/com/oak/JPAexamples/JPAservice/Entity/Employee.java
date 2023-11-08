package com.oak.JPAexamples.JPAservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
/*@Table(name = "employees",schema = "newone",uniqueConstraints = @UniqueConstraint(columnNames = "FirstName"),
 indexes = @Index(name = "email_index",columnList = "Email"))*/
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
   @Column(nullable = false,name = "Name")
    private String firstName;
   @Column(length = 60)
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @CreationTimestamp
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastUpdateDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "Id")
    private Address address;


}
