package com.oak.JPAexamples.JPAservice.Api;

import com.oak.JPAexamples.JPAservice.DTO.EmployeeDto;
import com.oak.JPAexamples.JPAservice.Entity.Employee;
import com.oak.JPAexamples.JPAservice.Services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeApi {

    private final EmployeeService employeeservice;


    //localhost:8080/employee
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getbyId(@PathVariable("id") long Id) {

        boolean control = employeeservice.existby(Id);
        if (control)
            System.out.println("Employee is present");
        else
            System.out.println("Employee is not in the Database");
        return new ResponseEntity<EmployeeDto>(employeeservice.getById(Id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<EmployeeDto>(employeeservice.save(employee), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getall() {

        System.out.println("The count is:" + employeeservice.count());
        return new ResponseEntity<List<EmployeeDto>>(employeeservice.getall(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") long Id, @RequestBody EmployeeDto employeedto) {
        employeedto.setId(Id);
        return new ResponseEntity<EmployeeDto>(employeeservice.update(employeedto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") long Id) {
        return new ResponseEntity<EmployeeDto>(employeeservice.deleteById(Id), HttpStatus.OK);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    public ResponseEntity<List<EmployeeDto>> employeepagination(@PathVariable("offset") int offset,
                                                                @PathVariable("pagesize") int pagesize) {
        return ResponseEntity.ok(employeeservice.pagination(offset, pagesize));
    }

    @GetMapping("/sortedlist/{direction}/{field}")
    public ResponseEntity<List<EmployeeDto>> sortinglist(@PathVariable("direction") String direction,
                                                         @PathVariable("field") String field) {
        return ResponseEntity.ok(employeeservice.sorting(direction, field));
    }

//    public ResponseEntity<List<Employee>> pagination()
//    {
//
//    }
}


//    @GetMapping
//    public ResponseEntity<Employee> save2() {
//    Employee employee=new Employee();
//    employee.setFirstName("Bernard");
//    employee.setLastName("Lewis");
//    employee.setEmail("bernard@tmail.com");
//    employee.setAge(80);
//    return ResponseEntity.ok(employeeservice.save(employee));
//    //manually
//       // return new ResponseEntity<Employee>(employeeservice.save(employee),HttpStatus.OK);
//    }
