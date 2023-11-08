package com.oak.JPAexamples.JPAservice.Services;

import com.oak.JPAexamples.JPAservice.DTO.EmployeeDto;
import com.oak.JPAexamples.JPAservice.Entity.Employee;
import com.oak.JPAexamples.JPAservice.Repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeerepository;
    private final ModelMapper modelmapper;

    @Override
    public EmployeeDto save(EmployeeDto employeedto) {

        Employee employee=modelmapper.map(employeedto,Employee.class);
        employee=employeerepository.save(employee);
        employeedto=modelmapper.map(employee,EmployeeDto.class);
        return employeedto;
//        Employee employee_added=new Employee();
//        employee_added.setFirstName(employee.getFirstName());
//        employee_added.setLastName(employee.getLastName());
//        employee_added.setEmail(employee.getEmail());
//        employee_added.setAge(employee.getAge());
       // employee_added=employeerepository.save(employee_added);
//        employee.setId(employee_added.getId());
//        employee.setCreatedDate(employee_added.getCreatedDate());
//        employee.setLastUpdateDate(employee_added.getLastUpdateDate());

        //or
//        employee=employeerepository.save(employee);
//        return employee;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeedto) {

        Employee employee=employeerepository.findById(employeedto.getId()).orElseThrow(()->new IllegalArgumentException());
        employee.setFirstName(employeedto.getFirstName());
        employee.setLastName(employeedto.getLastName());
        employee.setAge(employeedto.getAge());
        employee.setEmail(employeedto.getEmail());
        employee=employeerepository.save(employee);
        employeedto=modelmapper.map(employee,EmployeeDto.class);
        return employeedto;
    }

    @Override
    public List<EmployeeDto> getall() {
        List<Employee> employeelist=employeerepository.findAll();
        List<EmployeeDto> dtolist=employeelist.stream().map(employee -> modelmapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
        return dtolist;
    }

    @Override
    public EmployeeDto getById(long Id) {
        Optional<Employee> employee= employeerepository.findById(Id);
        EmployeeDto dto=modelmapper.map(employee,EmployeeDto.class);
        return dto;
    }

    @Override
    public EmployeeDto deleteById(long Id) {
        Employee employee=employeerepository.findById(Id).orElseThrow(()->new IllegalArgumentException());
        EmployeeDto employeeDto=modelmapper.map(employee,EmployeeDto.class);
        employeerepository.delete(employee);
       // employeerepository.deleteById(Id);
//        Delete list
//        List<Employee> list=employeerepository.findAll();
//        employeerepository.deleteAll(list);
        return employeeDto;
    }

    @Override
    public long count() {
        return employeerepository.count();
    }

    @Override
    public boolean existby(long Id) {
        return employeerepository.existsById(Id);
    }

    @Override
    public List<EmployeeDto> pagination(int offset, int pagesize) {
        Page<Employee> employeeList=employeerepository.findAll(PageRequest.of(offset,pagesize));
        List<EmployeeDto> dtoList=employeeList.stream().map(employee -> modelmapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public List<EmployeeDto> sorting(String direction, String field) {
        List<Employee> employeeList=new ArrayList<>();
        if(direction.equals("asc") || direction.equals("ASC"))
            employeeList=employeerepository.findAll(Sort.by(Sort.Direction.ASC,field));
        else
            employeeList=employeerepository.findAll(Sort.by(Sort.Direction.DESC,field));
        List<EmployeeDto> dtoList=employeeList.stream().map(employee -> modelmapper.map(employee,EmployeeDto.class))
                .collect(Collectors.toList());
        return dtoList;
    }


}
