package com.jrp.pma.dao;

import com.jrp.pma.entities.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    ProjectRepository projectR;

    @Test
    public void projectRepoTest(){
        Project project1= new Project("New test Project", "Complete", "Description");
        projectR.save(project1);
        Assertions.assertEquals(5,projectR.findAll().stream().count());
    }

}
