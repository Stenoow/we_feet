package com.wefeet.wefeet.services;

import com.wefeet.wefeet.entities.Discipline;
import com.wefeet.wefeet.entities.Trademark;
import com.wefeet.wefeet.repositories.TrademarksRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrademarksService {

    private final TrademarksRepository tradeMarksRepository;

    public TrademarksService(TrademarksRepository tradeMarksRepository) {
        this.tradeMarksRepository = tradeMarksRepository;
    }

    public List<Trademark> getAllTrademarks() {
        return this.tradeMarksRepository.findAll();
    }

    public void create(Trademark trademark) {
        this.tradeMarksRepository.save(trademark);
    }

    public boolean existsById(int id) {
        return tradeMarksRepository.existsById(id);
    }

    public Optional<Trademark> findById(int id) {
        return tradeMarksRepository.findById(id);
    }

    public void delete(int id) {
        tradeMarksRepository.deleteById(id);
    }
}
