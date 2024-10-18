package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.entities.DisciplineDTO;
import com.wefeet.wefeet.entities.SurfaceArea;
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
@RequestMapping(path = "disciplines", produces = APPLICATION_JSON_VALUE)
public class DisciplinesController {

    private DisciplinesService disciplinesService;
    private SurfaceAreaService surfaceAreaService;

    public DisciplinesController(DisciplinesService disciplinesService, SurfaceAreaService surfaceAreaService) {
        this.disciplinesService = disciplinesService;
        this.surfaceAreaService = surfaceAreaService;
    }

    @GetMapping()
    public @ResponseBody List<DisciplineDTO> getDisciplines() {
        return this.disciplinesService.getAllDisciplines();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Discipline discipline) {
        this.disciplinesService.create(discipline);
        ApiResponse response = new ApiResponse("Discipline is create with success", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{disciplineId}/surfaceArea/{surfaceAreaId}")
    public ResponseEntity<ApiResponse> addSurfaceAreaToDiscipline(
            @PathVariable Integer disciplineId,
            @PathVariable Integer surfaceAreaId
    ) {
        Discipline discipline = disciplinesService.findById(disciplineId)
                .orElseThrow(() -> new ResourceNotFoundException("Discipline not found"));
        SurfaceArea surfaceArea = surfaceAreaService.findById(surfaceAreaId)
                .orElseThrow(() -> new ResourceNotFoundException("SurfaceArea not found"));

        // Lier les entités
        discipline.getSurfaceAreas().add(surfaceArea);
        surfaceArea.getDisciplines().add(discipline);

        disciplinesService.create(discipline);
        surfaceAreaService.create(surfaceArea);

        ApiResponse response = new ApiResponse("Discipline with ID " + disciplineId + " and the SurfaceArea with ID " + surfaceAreaId + " relation created with success", HttpStatus.ACCEPTED.value());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
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
