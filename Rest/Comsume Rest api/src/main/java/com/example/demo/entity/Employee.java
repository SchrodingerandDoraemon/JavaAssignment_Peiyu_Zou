package com.example.demo.entity;




import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee {

    private long id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;

}
