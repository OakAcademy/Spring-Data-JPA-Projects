package com.oak.JPAexamples.JPAservice.Api;

import com.oak.JPAexamples.JPAservice.Entity.Employee;


import com.oak.JPAexamples.JPAservice.Entity.Task;
import com.oak.JPAexamples.JPAservice.Repositories.EmployeeRepository;


import com.oak.JPAexamples.JPAservice.Repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/querymethods")
@RequiredArgsConstructor
public class QueriesApi {

    private final EmployeeRepository employeeRepository;
    private final TaskRepository taskRepository;


    @GetMapping("/findbyfirstname")
    public ResponseEntity<List<Employee>> getByFirstName() {
        return ResponseEntity.ok(employeeRepository.findByFirstName("John"));
    }

    @GetMapping("/multiplefields")
    public ResponseEntity<List<Employee>> getByFirstNameandLastName() {
        return ResponseEntity.ok(employeeRepository.findByFirstNameAndLastName("Josh", "Malerman"));
    }

    @GetMapping("/multiplefieldsor")
    public ResponseEntity<List<Employee>> getByFirstNameorLastName() {
        return ResponseEntity.ok(employeeRepository.findByFirstNameOrLastName("Josh", "Malerman"));
    }

    @GetMapping("/containing")
    public ResponseEntity<List<Employee>> containing() {
        return ResponseEntity.ok(employeeRepository.findByEmailContaining("gmail"));
    }

    @GetMapping("/greater")
    public ResponseEntity<List<Employee>> greater() {
        return ResponseEntity.ok(employeeRepository.findByAgeGreaterThan(30));
    }

    @GetMapping("/less")
    public ResponseEntity<List<Employee>> less() {
        return ResponseEntity.ok(employeeRepository.findByAgeLessThan(40));
    }

    @GetMapping("/lessequal")
    public ResponseEntity<List<Employee>> lessequal() {
        return ResponseEntity.ok(employeeRepository.findByAgeLessThanEqual(40));
    }

    @GetMapping("greaterandless")
    public ResponseEntity<List<Employee>> greaterandless() {
        return ResponseEntity.ok(employeeRepository.findByAgeGreaterThanAndAgeLessThan(20, 50));
    }

    @GetMapping("between")
    public ResponseEntity<List<Employee>> between() {
        return ResponseEntity.ok(employeeRepository.findByAgeBetween(20, 50));
    }

    @GetMapping("/inusage")
    public ResponseEntity<List<Employee>> inUsage() {
        String[] namearray = {"Jacob", "Michael", "Adam", "Daniel", "John", "Josh", "Emily", "William"};
        return ResponseEntity.ok(employeeRepository.findByFirstNameIn(namearray));
    }

    @GetMapping("/first")
    public ResponseEntity<List<Employee>> first() {
        return ResponseEntity.ok(employeeRepository.findFirst3ByOrderByFirstNameAsc());
    }

    @GetMapping("/last")
    public ResponseEntity<List<Employee>> last() {
        return ResponseEntity.ok(employeeRepository.findLast3ByOrderByFirstNameDesc());
    }

    @GetMapping("/jpqlexample")
    public ResponseEntity<List<Employee>> jpql() {
        return ResponseEntity.ok(employeeRepository.findByAgeGreaterThanEqual(65));
    }

    @GetMapping("/native")
    public ResponseEntity<List<Employee>> nativequery()
    {
        return ResponseEntity.ok(employeeRepository.findLastNameEqual("Verdon"));
    }

    @GetMapping("/tasknamed")
    public ResponseEntity<List<Task>> tasknamed()
    {
        return ResponseEntity.ok(taskRepository.findByTime(30));
    }


}
