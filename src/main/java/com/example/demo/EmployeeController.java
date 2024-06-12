package com.example.demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //private final EmployeeRepository repository;
    @Autowired
    private DataLoaderService dataservice;

    @RequestMapping(value = "allEmployees", method = RequestMethod.GET)
    public @ResponseBody Collection<Employee> selectEmployee() {
        Collection<Employee> sec = dataservice.selectEmployee();
        return sec;
    }

    @RequestMapping(value = "allEmployees/id/{id}", method = RequestMethod.GET)
    public @ResponseBody Employee selectEmployeeById(@PathVariable int id) {
        Employee sec = dataservice.selectEmployeeById(id);
        return sec;
    }

    @RequestMapping(value = "allEmployees", method = RequestMethod.POST)
    public @ResponseBody Employee insertEmployee(@RequestBody Employee employee) {
        dataservice.insertEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "allEmployees/id/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteEmployee(@PathVariable int id) {
        dataservice.deleteEmployeeById(id);
    }

    @RequestMapping(value = "allEmployees", method = RequestMethod.PUT)
    public @ResponseBody Employee updateEmployee(@RequestBody Employee employee) {
        dataservice.updateEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "allEmployees/name/{name}", method = RequestMethod.GET)
    public @ResponseBody Employee selectEmployeeByName(@PathVariable String name) {
        Employee sec = dataservice.selectEmployeeByName(name);
        return sec;
    }

    @RequestMapping(value = "allEmployees/name/{name}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteEmployeeByName(@PathVariable String name) {
        dataservice.deleteEmployeeByName(name);
    }


    // Aggregate root
    // tag::get-aggregate-root[]
//    @GetMapping("/employees")
//    List<Employee> all() {
//        return Service.findAllStates();
//    }

    // end::get-aggregate-root[]

//    @PostMapping("/employees")
//    Employee newEmployee(@RequestBody Employee newEmployee) {
//        return repository.save(newEmployee);
//    }
//
//    // Single item
//
//    @GetMapping("/employees/{id}")
//    Employee one(@PathVariable Long id) {
//
//        return repository.findById(id)
//                .orElseThrow(() -> new EmployeeNotFoundException(id));
//    }

//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//
//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}