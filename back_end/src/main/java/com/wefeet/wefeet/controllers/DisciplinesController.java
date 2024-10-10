package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.services.DisciplinesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "disciplines", produces = APPLICATION_JSON_VALUE)
public class DisciplinesController {

    private DisciplinesService disciplinesService;

    public DisciplinesController(DisciplinesService disciplinesService) {
        this.disciplinesService = disciplinesService;
    }

    @GetMapping()
    public @ResponseBody List<Discipline> getShoes() {
        return this.disciplinesService.getAllDisciplines();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@Valid @RequestBody Discipline discipline) {
        this.disciplinesService.create(discipline);
        return new ResponseEntity<>("Discipline is create with success", HttpStatus.CREATED);
    }

    @DeleteMapping(path =  "{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        boolean exists = this.disciplinesService.existsById(id);
        if (!exists) {
            return new ResponseEntity<>("Discipline with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }

        this.disciplinesService.delete(id);
        return new ResponseEntity<>("Discipline is deleted with success", HttpStatus.ACCEPTED);
    }
}
