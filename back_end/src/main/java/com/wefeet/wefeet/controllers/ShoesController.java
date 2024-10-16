package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.*;
import com.wefeet.wefeet.enums.TypeSex;
import com.wefeet.wefeet.exceptions.ResourceNotFoundException;
import com.wefeet.wefeet.services.DisciplinesService;
import com.wefeet.wefeet.services.ShoesService;
import com.wefeet.wefeet.services.SurfaceAreaService;
import com.wefeet.wefeet.services.TrademarksService;
import com.wefeet.wefeet.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "shoes", produces = APPLICATION_JSON_VALUE)
public class ShoesController {

    private final ShoesService shoesService;
    private final DisciplinesService disciplinesService;
    private final TrademarksService trademarksService;
    private final SurfaceAreaService surfaceAreaService;

    public ShoesController(ShoesService shoesService, DisciplinesService disciplinesService, TrademarksService trademarksService, SurfaceAreaService surfaceAreaService) {
        this.shoesService = shoesService;
        this.disciplinesService = disciplinesService;
        this.trademarksService = trademarksService;
        this.surfaceAreaService = surfaceAreaService;
    }

    @GetMapping()
    public @ResponseBody List<Shoes> getShoes() {
        return this.shoesService.getAllShoes();
    }

    @GetMapping(path = "/filter")
    public ResponseEntity<List<Shoes>> filterShoes(
            @RequestParam() TypeSex sex,
            @RequestParam() Integer price,
            @RequestParam() Integer size,
            @RequestParam() Long disciplineId,
            @RequestParam() Long surfaceareaId,
            @RequestParam(required = false) Long trademarkId) {

        double minPrice = 0.0;
        double maxPrice = switch (price) {
            case 0 -> {
                minPrice = 0.0;
                yield 80.0;
            }
            case 1 -> {
                minPrice = 80.0;
                yield 150.0;
            }
            case 2 -> {
                minPrice = 150.0;
                yield 200.0;
            }
            case 3 -> {
                minPrice = 200.0;
                yield 1000.0;
            }
            default -> 0.0;
        };

        List<Shoes> filteredShoes = shoesService.filterShoes(sex, minPrice, maxPrice, size, disciplineId, trademarkId, surfaceareaId);

        return ResponseEntity.ok(filteredShoes);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> create(@RequestBody ShoesDTO shoesDTO) {

        Discipline discipline = this.disciplinesService.findById(shoesDTO.getDisciplineId())
                .orElseThrow(() -> new ResourceNotFoundException("Discipline not found"));

        Trademark trademark = this.trademarksService.findById(shoesDTO.getTrademarkId())
                .orElseThrow(() -> new ResourceNotFoundException("Trademark not found"));

        SurfaceArea surfacearea = this.surfaceAreaService.findById(shoesDTO.getSurfaceareaId())
                .orElseThrow(() -> new ResourceNotFoundException("SurfaceArea not found"));

        Shoes shoes = new Shoes(
                shoesDTO.getName(),
                TypeSex.valueOf(shoesDTO.getSex()),
                shoesDTO.getPrice(),
                shoesDTO.getMinSize(),
                shoesDTO.getMaxSize(),
                shoesDTO.getLink(),
                discipline,
                trademark,
                surfacearea
        );

        // Save Entity Shoes in BDD
        this.shoesService.create(shoes);

        ApiResponse response = new ApiResponse("Shoes created successfully", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
