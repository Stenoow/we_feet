package com.wefeet.wefeet.controllers;

import com.wefeet.wefeet.entities.Trademark;
import com.wefeet.wefeet.services.TrademarksService;
import com.wefeet.wefeet.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "trademarks", produces = APPLICATION_JSON_VALUE)
public class TrademarksController {

    private final TrademarksService trademarksService;

    public TrademarksController(TrademarksService trademarksService) {
        this.trademarksService = trademarksService;
    }

    @GetMapping()
    public @ResponseBody List<Trademark> getShoes() {
        return this.trademarksService.getAllTrademarks();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Trademark trademark) {
        this.trademarksService.create(trademark);
        ApiResponse response = new ApiResponse("Trademark is create with success", HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping(path =  "{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable int id) {
        boolean exists = this.trademarksService.existsById(id);
        if (!exists) {
            ApiResponse response = new ApiResponse("Trademark with ID " + id + " not found", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        this.trademarksService.delete(id);
        ApiResponse response = new ApiResponse("Trademark is deleted with success", HttpStatus.ACCEPTED.value());
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
