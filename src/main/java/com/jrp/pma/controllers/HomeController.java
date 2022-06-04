package com.jrp.pma.controllers;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.EmployeeProject;
import com.jrp.pma.entities.Project;
import com.jrp.pma.service.EmployeeService;
import com.jrp.pma.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectService projectS;

    @Autowired
    EmployeeService employeeS;

    @Value("${version}")
    private String version;

    @GetMapping("/")
    public String displayHome(Model model) {

        List<Project> projects = projectS.findAll();
        model.addAttribute("projectList", projects);

        List<EmployeeProject> employeeProject = employeeS.employeeProjectList();
        model.addAttribute("employeeListProjectsCnt", employeeProject);

        List<ChartData> chartData = projectS.projectState();
        model.addAttribute("chartValues",chartData);

        model.addAttribute("appVersion",version);

        return "main/home";
    }

}
