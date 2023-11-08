package com.rest.SpringRest.Controller;

import com.rest.SpringRest.Model.Product;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")

public class ProductController {

    public List<Product> FillList()
    {
        List<Product> list=new ArrayList<>();
        Product p1=new Product();
        p1.setId(1);
        p1.setName("John");
        list.add(p1);
        Product p2=new Product();
        p2.setId(2);
        p2.setName("David");
        list.add(p2);
        Product p3=new Product();
        p3.setId(3);
        p3.setName("Jack");
        list.add(p3);
        Product p4=new Product();
        p4.setId(4);
        p4.setName("Lizy");
        list.add(p4);
        Product p5=new Product();
        p5.setId(5);
        p5.setName("George");
        list.add(p5);
        return list;

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findall() {
        List<Product> list = new ArrayList<>();
        list=FillList();
        return list;
    }
    @GetMapping("/Id")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable("Id") long Id)
    {
        Product product=new Product();
        return product;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product Create (@RequestBody Product product)
    {
        return new Product();
    }
    @PutMapping("/Id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  Product Update(@PathVariable("Id") long Id,@RequestBody Product product)
    {
        return new Product();
    }
    @DeleteMapping("Id")
    @ResponseStatus(HttpStatus.OK)
    public  Product Delete(@PathVariable("Id") long Id)
    {
        return new Product();
    }








}
