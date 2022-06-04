package com.jrp.pma.service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectR;

    public Project save(Project project){
        return projectR.save(project);
    }

    public List<Project> findAll(){
        return projectR.findAll();
    }

    public List<ChartData> projectState(){
        return projectR.projectStateChart();
    }

}
