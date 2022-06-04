package com.jrp.pma.service;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeR;


    public List<Employee> findAll() {
        return (List<Employee>) employeeR.findAll();
    }

    public Iterable<Employee> findAll (Pageable pageable){
        return employeeR.findAll(pageable);
    }

    public Optional<Employee> findById(long id) {
        return employeeR.findById(id);
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeR.findByEmail(email);
    }

    public Employee save(Employee employee) {
        return employeeR.save(employee);
    }

    public List<EmployeeProject> employeeProjectList() {
        return employeeR.employeeProjects();
    }

    public void deleteById(long id) {
        employeeR.deleteById(id);
    }


}
