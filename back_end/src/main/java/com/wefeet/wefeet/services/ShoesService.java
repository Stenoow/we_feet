package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Shoes;
import com.wefeet.wefeet.repositories.ShoesRepository;
import org.springframework.stereotype.Service;
import com.wefeet.wefeet.enums.TypeSex;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoesService {

    private final ShoesRepository shoesRepository;

    public ShoesService(ShoesRepository shoesRepository) {
        this.shoesRepository = shoesRepository;
    }

    public List<Shoes> getAllShoes() {
        return this.shoesRepository.findAll();
    }

    public List<Shoes> filterShoes(TypeSex sex, Double minPrice, Double maxPrice, Integer size, Long disciplineId, Long trademarkId, Long surfaceareaId) {
        List<Shoes> filteredShoes = shoesRepository.findAll().stream()
                .filter(shoe -> (shoe.getSex().equals(sex) || shoe.getSex().equals(TypeSex.UNISEX)) &&
                        (shoe.getPrice() <= maxPrice && shoe.getPrice() >= minPrice) &&
                        (shoe.getMinSize() <= size && shoe.getMaxSize() >= size) &&
                        (shoe.getDiscipline().getId() == disciplineId) &&
                        (shoe.getSurfacearea().getId() == surfaceareaId))
                .collect(Collectors.toList());
        if (trademarkId != null) {
            filteredShoes.sort(Comparator.comparing(shoe -> {
                return shoe.getTrademark().getId() == trademarkId ? 0 : 1; // Place les chaussures correspondant au trademarkId en premier
            }));
        }

        return filteredShoes;
    }

    public void create(Shoes shoes) {
        this.shoesRepository.save(shoes);
    }
}
