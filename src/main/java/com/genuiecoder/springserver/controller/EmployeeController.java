package com.genuiecoder.springserver.controller;

import com.genuiecoder.springserver.model.employee.Employee;
import com.genuiecoder.springserver.model.employee.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee/get-all")
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @PostMapping("/employee/save")
    public Employee save(@RequestBody Employee employee) {
        return employeeDao.save(employee);
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDao.delete(id);
        return "Employee with ID " + id + " has been deleted.";
    }

}
