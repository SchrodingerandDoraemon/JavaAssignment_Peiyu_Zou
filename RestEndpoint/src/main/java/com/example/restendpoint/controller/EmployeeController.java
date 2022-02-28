package com.example.restendpoint.controller;


import com.example.restendpoint.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, httpHeaders);
        return restTemplate.exchange("http://dummy.restapiexample.com/api/v1/create", HttpMethod.POST, entity, String.class).getBody();
    }


    @GetMapping("/employee/{id}")
    public String findEmployeeById(@PathVariable Integer id) {
        String uri = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/allEmployee")
    public String getEmployees() {
        String uri = "http://dummy.restapiexample.com/api/v1/employees";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    //Update an employee
    @PutMapping("/employee/{id}")
    public String updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept((Arrays.asList(MediaType.APPLICATION_JSON)));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        return restTemplate.exchange("http://dummy.restapiexample.com/api/v1/update/" + id, HttpMethod.PUT, entity, String.class).getBody();
    }

    //Delete an employee
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);

        return restTemplate.exchange(
                "http://dummy.restapiexample.com/api/v1/delete/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

}
