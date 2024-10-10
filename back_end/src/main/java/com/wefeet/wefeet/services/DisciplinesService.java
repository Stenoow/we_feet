package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.repositories.DisciplinesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinesService {

    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesService(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    public List<Discipline> getAllDisciplines() {
        return this.disciplinesRepository.findAll();
    }

    public void create(Discipline discipline) {
        this.disciplinesRepository.save(discipline);
    }

    public boolean existsById(int id) {
        return disciplinesRepository.existsById(id);
    }

    public void delete(int id) {
        this.disciplinesRepository.deleteById(id);
    }
}
