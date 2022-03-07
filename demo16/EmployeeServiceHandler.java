package com.somesh.web.demo16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeServiceHandler {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAllNumberOfEmployee(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee findAnyOneEmployee(@PathVariable int id){
        Employee one = employeeService.findOne(id);
        if(one == null){
            throw new Resources_Not_Found("id "+id);
        }
        return one;
    }

    @PostMapping("/employees")
    public ResponseEntity createUsers(@Valid @RequestBody Employee e){
        Employee savedEmployees = employeeService.saveEmployees(e);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployees.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteUsers(@PathVariable int id){
        Employee e = employeeService.deleteById(id);
        if(e == null){
            throw new Resources_Not_Found("id :"+id);
        }
    }

    @PutMapping("employees/{id}")
    public Employee updateEmployees(@RequestBody Employee emp,@PathVariable int id){
        this.employeeService.updateData(emp , id);
        return emp;
    }


}
