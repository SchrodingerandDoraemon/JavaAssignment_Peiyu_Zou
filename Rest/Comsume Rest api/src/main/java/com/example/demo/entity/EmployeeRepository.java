package com.example.demo.entity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    List<Employee> employeeList = new ArrayList<>();
//
//    public List<Employee> getAll() {
//        return employeeList;
//    }
//
//    public String add(Employee emp) {
//        employeeList.add(emp);
//        return "Successfully added!";
//    }
//
//    public String edit(Employee emp) {
//        employeeList.stream().filter(e -> e.getId() == emp.getId()).forEach(e -> {
//            e.setEmployee_name(emp.getEmployee_name());
//            e.setEmployee_age(emp.getEmployee_age());
//            e.setEmployee_salary(emp.getEmployee_salary());
//            e.setProfile_image(emp.getProfile_image());
//        });
//        return "Successfully updated!";
//    }
//
//    public String delete(int id) {
//        employeeList.remove(id);
//        return "Deleted!";
//    }
}
