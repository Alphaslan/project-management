package com.jrp.pma.controllers.api;

import com.jrp.pma.entities.Employee;
import com.jrp.pma.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Validated
@RestController
@RequestMapping("/api-app/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeService employeeS;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> getEmployees() {
        return employeeS.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        if (!employeeS.findById(id).isPresent())
            return null;
        return employeeS.findById(id).get();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody @Valid Employee e) {
        return employeeS.save(e);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@RequestBody @Valid Employee employee) {
        return employeeS.save(employee);
    }


    @PatchMapping("update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee partialUpdate(@PathVariable("id") long id, @RequestBody @Valid Employee patchEmployee) {
        if (!employeeS.findById(id).isPresent())
            return null;

        Employee emp = employeeS.findById(id).get();

        if (patchEmployee.getEmail() != null) {
            emp.setEmail(patchEmployee.getEmail());
        }
        if (patchEmployee.getFirstName() != null) {
            emp.setFirstName(patchEmployee.getFirstName());
        }
        if (patchEmployee.getLastName() != null) {
            emp.setLastName(patchEmployee.getLastName());
        }
        return employeeS.save(emp);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        if (employeeS.findById(id).isPresent())
            employeeS.deleteById(id);
    }

    @GetMapping(params = {"page", "size"})
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page,
                                                     @RequestParam("size") int size) {
        Pageable pageAndSize = PageRequest.of(page, size);

        return employeeS.findAll(pageAndSize);
    }


}
