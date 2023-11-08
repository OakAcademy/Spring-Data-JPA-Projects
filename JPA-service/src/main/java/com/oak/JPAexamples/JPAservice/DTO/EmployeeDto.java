package com.oak.JPAexamples.JPAservice.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
public class EmployeeDto {

    private long Id;

    private String FirstName;

    private String LastName;

    private String Email;
    private int Age;

    private Timestamp CreatedDate;

    private Timestamp LastUpdateDate;
}
