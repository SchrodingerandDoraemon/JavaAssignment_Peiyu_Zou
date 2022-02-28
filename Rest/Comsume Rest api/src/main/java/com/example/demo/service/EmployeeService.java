package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired

    EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public String add(Employee employee) {
        return employeeRepository.save(employee);
    }

//    public String edit(Employee employee) {
//        return employeeRepository.saveAllAndFlush(employee);
//    }

    public String delete(Employee employee,) {
        return employeeRepository.delete(employee.);
    }
}
