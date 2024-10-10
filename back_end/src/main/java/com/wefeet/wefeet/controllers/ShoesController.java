package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.Shoes;
import com.wefeet.wefeet.services.ShoesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "shoes", produces = APPLICATION_JSON_VALUE)
public class ShoesController {

    private ShoesService shoesService;

    public ShoesController(ShoesService shoesService) {
        this.shoesService = shoesService;
    }

    @GetMapping()
    public @ResponseBody List<Shoes> getShoes() {
        return this.shoesService.getAllShoes();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Shoes shoes) {
        this.shoesService.create(shoes);
    }
}
