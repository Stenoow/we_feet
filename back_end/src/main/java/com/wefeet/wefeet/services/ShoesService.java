package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Shoes;
import com.wefeet.wefeet.repositories.ShoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoesService {

    private final ShoesRepository shoesRepository;

    public ShoesService(ShoesRepository shoesRepository) {
        this.shoesRepository = shoesRepository;
    }

    public List<Shoes> getAllShoes() {
        return this.shoesRepository.findAll();
    }

    public void create(Shoes shoes) {
        this.shoesRepository.save(shoes);
    }
}
