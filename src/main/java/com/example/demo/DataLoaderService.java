package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DataLoaderService {

    private final RowMapper<Employee> selectEmployee = (rs, i) -> Employee.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("Name"))
            .role(rs.getString("Role")).build();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> selectEmployee() {
        String sql = "select id, name, role from test.employee";
        List<Employee> res = jdbcTemplate.query(sql, selectEmployee);
        return res;
    }

    public Employee selectEmployeeById(int id) {
        String sql = "select id, name, role from test.employee where id = ?";
        Employee res = jdbcTemplate.queryForObject(sql, selectEmployee, id);
        return res;
    }

    public Employee insertEmployee(Employee employee) {
        String sql = "insert into test.employee (id, name, role) values (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getRole());
        return employee;
    }

    public int deleteEmployeeById(int id) {
        String sql = "delete from test.employee where id = ?";
        jdbcTemplate.update(sql, id);
        return id;
    }

    public Employee updateEmployee(Employee employee) {
        String sql = "update test.employee set name = ?, role = ? where id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getId());
        return employee;
    }

    public Employee selectEmployeeByName(String name) {
        String sql = "select id, name, role from test.employee where name = ?";
        Employee res = jdbcTemplate.queryForObject(sql, selectEmployee, name);
        return res;
    }

    public void deleteEmployeeByName(String name) {
        String sql = "delete from test.employee where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
