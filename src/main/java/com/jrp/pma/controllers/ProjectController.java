package com.jrp.pma.controllers;

import com.jrp.pma.dao.EmployeeRepository;
import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Employee;
import com.jrp.pma.entities.Project;
import com.jrp.pma.service.EmployeeService;
import com.jrp.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectService projectS;

    @Autowired
    EmployeeService employeeS;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        List<Employee> employees =employeeS.findAll();
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProjectModel(Project project) {
        projectS.save(project);
        return "redirect:/projects";
    }

    @GetMapping()
    public String listProjects(Model model) {
        List<Project> projects = projectS.findAll();
        model.addAttribute("projectList", projects);
        return "projects/list-projects";
    }


}
