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

    public List<Ashes> search(Long id, String name) {
        if (id != null) {
            return ashesRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return ashesRepository.findByNameContaining(name);
        }
        return ashesRepository.findAll();
    }

    public Ashes create(Ashes entity) {
        if (entity.getId() != null) {
            Optional<Ashes> existingAshes = ashesRepository.findById(entity.getId());
            if (existingAshes.isPresent()) {
                throw new RuntimeException("Spirits Ashes with ID " + entity.getId() + " already exists.");
            }
        }
        return save(entity);
    }

    public Ashes save(Ashes entity) {
        return ashesRepository.save(entity);
    }

    public void deleteById(Long id) {
        ashesRepository.deleteById(id);
    }

    public Ashes update(Long id, Ashes entity) {
        Ashes ashes = ashesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spirits Ashes not found"));
        ashes.setName(entity.getName());
        ashes.setType(entity.getType());
        ashes.setFpCost(entity.getFpCost());
        ashes.setHpCost(entity.getHpCost());
        ashes.setEffect(entity.getEffect());
        ashes.setDlc(entity.getDlc());
        ashes.setImage(entity.getImage());
        return save(ashes);
    }
}
