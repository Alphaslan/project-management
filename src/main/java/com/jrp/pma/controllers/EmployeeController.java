package com.jrp.pma.controllers;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeS;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployeeModel(Employee employee) {
        employeeS.save(employee);
        return "redirect:/employees";
    }

    @GetMapping()
    public String listEmployees(Model model){
        List<Employee> employees=employeeS.findAll();
        model.addAttribute("employeeList",employees);
        return "employees/list-employees";
    }

}
