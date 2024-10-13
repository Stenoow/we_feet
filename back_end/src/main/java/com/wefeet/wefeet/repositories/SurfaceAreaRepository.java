package com.wefeet.wefeet.repositories;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.entities.SurfaceArea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurfaceAreaRepository extends JpaRepository<SurfaceArea, Integer> {
    List<SurfaceArea> findByDisciplines(Discipline discipline);
}
