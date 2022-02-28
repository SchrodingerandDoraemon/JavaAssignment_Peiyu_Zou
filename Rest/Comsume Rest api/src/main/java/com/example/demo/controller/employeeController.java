package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class employeeController {
    @RestController
    @RequestMapping("/emp")
    public class EmployeeController {

        @Autowired
        EmployeeService employeeService;

        @GetMapping("/get/all")
        public List<Employee> getAll() {
            return employeeService.getAll();
        }

        @PostMapping("/add")
        public String add(@RequestBody Employee emp) {
            return employeeService.add(emp);
        }

//        @PutMapping("/edit")
//        public String edit(@RequestBody Employee emp) {
//            return employeeService.edit(emp);
//        }

        @DeleteMapping ("/delete")
        public String delete(@RequestParam Employee employee) {
            return employeeService.delete(employee);
        }
    }
}
