package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PayrollApplicationTests {

	@Test
	void testId() {
		Employee employee = new Employee();
		int id = employee.getId();
		assertEquals(0, id);
	}

	@Test
	void testName() {
		Employee employee = new Employee();
		String name = "John Doe";
		employee.setName(name);
		assertEquals(name, employee.getName());
	}

	@Test
	void testRole() {
		Employee employee = new Employee();
		String role = "Student";
		employee.setRole(role);
		assertEquals(role, employee.getRole());
	}

}
