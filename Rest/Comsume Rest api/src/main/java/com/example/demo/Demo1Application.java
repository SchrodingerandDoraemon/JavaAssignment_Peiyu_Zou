package com.example.demo;

import com.example.demo.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.Quote;

import java.util.List;

@SpringBootApplication
public class Demo1Application {

    private static final Logger log = LoggerFactory.getLogger(Demo1Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Quote quote = restTemplate.getForObject(
                    "http://dummy.restapiexample.com/api/v1/employees", Quote.class);

            restTemplate.delete("http://dummy.restapiexample.com/api/v1/delete/2");
            List<Employee> employeeList = quote.getData();
            System.out.println(employeeList);
            for (Employee employee : employeeList){
                if (employee.getEmployee_age() >= 60){
                    System.out.println(employee);
                }
            }
            log.info(quote.toString());
        };
    }

}
