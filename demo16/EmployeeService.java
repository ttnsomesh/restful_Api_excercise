package com.somesh.web.demo16;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeService {
    private static List<Employee> employees = new ArrayList<>();
    private static int countPrimary = 3;

    static {
        employees.add(new Employee(1,"somesh",23));
        employees.add(new Employee(2,"dinesh",24));
        employees.add(new Employee(3,"tushar",25));
    }

    public List<Employee> findAllEmployees(){
        return employees;
    }

    public Employee saveEmployees(Employee e){
        if(e.getId() == null){
            e.setId(++countPrimary);
        }
        employees.add(e);
        return e;
    }
    public Employee findOne(int id){
        for(Employee e : employees){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public Employee deleteById(int id){
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()){
            Employee e = it.next();
            if(e.getId() == id){
                it.remove();
                return e;
            }
        }
        return null;
    }

    public void updateData(Employee e , int id){
           employees = employees.stream().map(v ->{

                if(v.getId() == id){
                    v.setName("sourav");
                    v.setAge(25);
                }
                return  v;
            }).collect(Collectors.toList());
    }
}
