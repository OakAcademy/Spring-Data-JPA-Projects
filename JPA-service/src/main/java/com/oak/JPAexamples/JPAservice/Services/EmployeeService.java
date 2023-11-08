package com.oak.JPAexamples.JPAservice.Services;

import com.oak.JPAexamples.JPAservice.DTO.EmployeeDto;
import com.oak.JPAexamples.JPAservice.Entity.Employee;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto save(EmployeeDto employee);
    public EmployeeDto update(EmployeeDto employeedto);
    public List<EmployeeDto> getall();
    public EmployeeDto getById(long Id);
    public EmployeeDto deleteById(long Id);
    public long count();
    public boolean existby(long Id);
    public List<EmployeeDto> pagination(int offset,int pagesize);
    public List<EmployeeDto> sorting(String direction,String field);

}
