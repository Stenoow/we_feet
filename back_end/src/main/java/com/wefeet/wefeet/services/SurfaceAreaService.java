package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.entities.DisciplineDTO;
import com.wefeet.wefeet.entities.SurfaceArea;
import com.wefeet.wefeet.entities.SurfaceAreaDTO;
import com.wefeet.wefeet.repositories.SurfaceAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SurfaceAreaService {

    private final SurfaceAreaRepository surfaceAreaRepository;

    public SurfaceAreaService(SurfaceAreaRepository surfaceAreaRepository) {
        this.surfaceAreaRepository = surfaceAreaRepository;
    }

    public List<SurfaceAreaDTO> getAllTrademarks(Discipline discipline) {
        List<SurfaceArea> surfaceAreas = surfaceAreaRepository.findAll();
        if (discipline == null) {
            surfaceAreas = surfaceAreaRepository.findByDisciplines(discipline);
        }
        return surfaceAreas.stream().map(surface -> new SurfaceAreaDTO(surface.getId(), surface.getName())).collect(Collectors.toList());
    }

    public void create(SurfaceArea surfaceArea) {
        surfaceAreaRepository.save(surfaceArea);
    }

    public boolean existsById(int id) {
        return surfaceAreaRepository.existsById(id);
    }

    public Optional<SurfaceArea> findById(int id) {
        return surfaceAreaRepository.findById(id);
    }

    public void delete(int id) {
        surfaceAreaRepository.deleteById(id);
    }
}
