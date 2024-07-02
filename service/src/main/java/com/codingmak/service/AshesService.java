package com.codingmak.service;

import com.codingmak.model.Ashes;
import com.codingmak.repositories.AshesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AshesService {

    @Autowired
    private AshesRepository ashesRepository;

    public List<Ashes> findAllAshes() {
        return ashesRepository.findAll();
    }

    public Ashes saveAshes(Ashes ashes) {
        return ashesRepository.save(ashes);
    }

    public Optional<Ashes> findById(Long id) {
        return ashesRepository.findById(id);
    }
}
