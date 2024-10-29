package com.genuiecoder.springserver;

import com.genuiecoder.springserver.model.employee.Employee;
import com.genuiecoder.springserver.model.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;
	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setName("Rahul");
		employee.setLocation("Paskura,West Bengal");
		employee.setBranch("ECE");
		employeeDao.save(employee);
	}

//	@Test
	void getAllEmployeesAndDeleteThem() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			employeeDao.delete(employee.getId());
		}
	}

}
