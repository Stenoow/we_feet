package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.SurfaceArea;
import com.wefeet.wefeet.entities.Trademark;
import com.wefeet.wefeet.repositories.SurfaceAreaRepository;
import com.wefeet.wefeet.repositories.TrademarksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurfaceAreaService {

    private final SurfaceAreaRepository surfaceAreaRepository;

    public SurfaceAreaService(SurfaceAreaRepository surfaceAreaRepository) {
        this.surfaceAreaRepository = surfaceAreaRepository;
    }

    public List<SurfaceArea> getAllTrademarks() {
        return surfaceAreaRepository.findAll();
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
