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

}
