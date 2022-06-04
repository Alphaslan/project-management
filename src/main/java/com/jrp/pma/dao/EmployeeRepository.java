package com.jrp.pma.dao;

import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource(collectionResourceRel = "restEmployeeEndpoint",path = "rest-employees")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(nativeQuery = true, value = "SELECT E.first_name as firstName, E.last_name as lastName, COUNT(P.employee_id) as projectCount " +
            "FROM employee E left join project_employee P ON P.employee_id = E.employee_id " +
            "GROUP BY E.first_name, E.last_name ORDER BY 3 DESC")
    List<EmployeeProject> employeeProjects();

    Optional <Employee> findByEmail(String email);

}