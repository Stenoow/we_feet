package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.entities.DisciplineDTO;
import com.wefeet.wefeet.repositories.DisciplinesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinesService {

    private final DisciplinesRepository disciplinesRepository;

    public DisciplinesService(DisciplinesRepository disciplinesRepository) {
        this.disciplinesRepository = disciplinesRepository;
    }

    public List<DisciplineDTO> getAllDisciplines() {
        List<Discipline> disciplines = disciplinesRepository.findAll();
        return disciplines.stream().map(d -> new DisciplineDTO(d.getId(), d.getName())).collect(Collectors.toList());
    }

    public void create(Discipline discipline) {
        this.disciplinesRepository.save(discipline);
    }

    public boolean existsById(int id) {
        return disciplinesRepository.existsById(id);
    }

    public Optional<Discipline> findById(int id) {
        return disciplinesRepository.findById(id);
    }

    public void delete(int id) {
        this.disciplinesRepository.deleteById(id);
    }
}
