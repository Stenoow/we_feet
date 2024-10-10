package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.SurfaceArea;
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

    public SurfaceAreaController(SurfaceAreaService surfaceAreaService) {
        this.surfaceAreaService = surfaceAreaService;
    }

    @GetMapping()
    public @ResponseBody List<SurfaceArea> getShoes() {
        return this.surfaceAreaService.getAllTrademarks();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody SurfaceArea surfaceArea) {
        this.surfaceAreaService.create(surfaceArea);
        ApiResponse response = new ApiResponse("SurfaceArea is create with success", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
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
