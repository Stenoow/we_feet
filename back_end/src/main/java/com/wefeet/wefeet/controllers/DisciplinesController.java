package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.services.DisciplinesService;
import com.wefeet.wefeet.utils.ApiResponse;
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
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Discipline discipline) {
        this.disciplinesService.create(discipline);
        ApiResponse response = new ApiResponse("Discipline is create with success", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path =  "{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int id) {
        boolean exists = this.disciplinesService.existsById(id);
        if (!exists) {
            ApiResponse response = new ApiResponse("Discipline with ID " + id + " not found", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        this.disciplinesService.delete(id);
        ApiResponse response = new ApiResponse("Discipline is deleted with success", HttpStatus.ACCEPTED.value());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
