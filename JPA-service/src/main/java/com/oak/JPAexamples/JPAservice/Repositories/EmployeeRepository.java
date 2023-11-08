package com.oak.JPAexamples.JPAservice.Repositories;

import com.oak.JPAexamples.JPAservice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

    List<Employee> findByEmailContaining(String email);

    List<Employee> findByAgeGreaterThan(int age);

    List<Employee> findByAgeLessThan(int age);

    List<Employee> findByAgeLessThanEqual(int age);

    List<Employee> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);

    List<Employee> findByAgeBetween(int age1, int age2);

    List<Employee> findByFirstNameIn(String[] array);

    List<Employee> findFirst3ByOrderByFirstNameAsc();

    List<Employee> findLast3ByOrderByFirstNameDesc();

    @Query("SELECT e FROM Employee e WHERE e.age> :age")
    List<Employee> findByAgeGreaterThanEqual(@Param("age") Integer age);

    @Query(nativeQuery = true, value = "SELECT * FROM Employee e WHERE e.last_name= :lastname")
    List<Employee> findLastNameEqual(@Param("lastname") String lastname);
}