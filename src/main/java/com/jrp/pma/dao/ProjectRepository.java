package com.jrp.pma.dao;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Override
    List<Project> findAll();

    @Query(nativeQuery = true,
            value = "SELECT stage as label, COUNT(*) as value " +
            "FROM project " +
            "GROUP BY stage")
    List<ChartData> projectStateChart();

}
