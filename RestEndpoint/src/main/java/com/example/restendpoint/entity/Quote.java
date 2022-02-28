package com.example.restendpoint.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Quote {
    private String status;
    private List<Employee> data;
    private String message;
}
