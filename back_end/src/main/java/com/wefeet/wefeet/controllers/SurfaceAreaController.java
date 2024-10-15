package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.*;
import com.wefeet.wefeet.exceptions.ResourceNotFoundException;
import com.wefeet.wefeet.services.DisciplinesService;
import com.wefeet.wefeet.services.SurfaceAreaService;
import com.wefeet.wefeet.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "surfacearea", produces = APPLICATION_JSON_VALUE)
public class SurfaceAreaController {

    private final SurfaceAreaService surfaceAreaService;
    private final DisciplinesService disciplinesService;

    public SurfaceAreaController(SurfaceAreaService surfaceAreaService, DisciplinesService disciplinesService) {
        this.surfaceAreaService = surfaceAreaService;
        this.disciplinesService = disciplinesService;
    }

    @GetMapping()
    public @ResponseBody List<SurfaceArea> getShoes(@RequestParam(required = false) Integer disciplineId) {
        Discipline discipline = null;

        if (disciplineId != null && disciplineId != 0) {
            discipline = this.disciplinesService.findById(disciplineId)
                    .orElseThrow(() -> new ResourceNotFoundException("Discipline not found"));
        }

        return this.surfaceAreaService.getAllTrademarks(discipline);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody SurfaceArea surfaceArea) {
        this.surfaceAreaService.create(surfaceArea);
        ApiResponse response = new ApiResponse("SurfaceArea is create with success", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{surfaceAreaId}/discipline/{disciplineId}")
    public ResponseEntity<ApiResponse> addDisciplineToSurfaceArea(
            @PathVariable Integer surfaceAreaId,
            @PathVariable Integer disciplineId
    ) {
        SurfaceArea surfaceArea = surfaceAreaService.findById(surfaceAreaId)
                .orElseThrow(() -> new ResourceNotFoundException("SurfaceArea not found"));
        Discipline discipline = disciplinesService.findById(disciplineId)
                .orElseThrow(() -> new ResourceNotFoundException("Discipline not found"));

        // Lier les entités
        surfaceArea.getDisciplines().add(discipline);
        discipline.getSurfaceAreas().add(surfaceArea);

        surfaceAreaService.create(surfaceArea);
        disciplinesService.create(discipline);

        ApiResponse response = new ApiResponse("SurfaceArea with ID " + surfaceAreaId + " and the Discipline with ID " + disciplineId + " relation created with success", HttpStatus.ACCEPTED.value());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path =  "{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int id) {
        boolean exists = this.surfaceAreaService.existsById(id);
        if (!exists) {
            ApiResponse response = new ApiResponse("SurfaceArea with ID " + id + " not found", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        this.surfaceAreaService.delete(id);
        ApiResponse response = new ApiResponse("SurfaceArea is deleted with success", HttpStatus.ACCEPTED.value());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
