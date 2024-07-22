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
}
