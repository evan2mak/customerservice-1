package edu.p565.demo1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.p565.demo1.model.Customer;
import edu.p565.demo1.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    // Get https:localhost:8080/customers
    @GetMapping
    public List<Customer> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int create(@RequestBody Customer customer){
        return repository.create(customer);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable int id){
        repository.update(customer, id);
    }
   
    
}