package com.codingmak.service;

import com.codingmak.model.Spiritsash;
import com.codingmak.repositories.SpiritsashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpiritsashService {

    @Autowired
    private SpiritsashRepository spiritsashRepository;

    @Autowired
    private UniqueIdChecker uniqueIdChecker;

    public List<Spiritsash> search(Long id, String name) {
        if (id != null) {
            return spiritsashRepository.findById(id).stream().toList();
        }
        if (name != null) {
            return spiritsashRepository.findByNameContaining(name);
        }
        return spiritsashRepository.findAll();
    }

    public Spiritsash create(Spiritsash entity) {
        if (entity.getId() != null) {
            uniqueIdChecker.checkUniqueId(entity.getId());
        }
        return save(entity);
    }

    public Spiritsash save(Spiritsash entity) {
        return spiritsashRepository.save(entity);
    }

    public void deleteById(Long id) {
        spiritsashRepository.deleteById(id);
    }

    public Spiritsash update(Long id, Spiritsash entity) {
        Spiritsash spiritsash = spiritsashRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spirits Ashes not found"));
        spiritsash.setName(entity.getName());
        spiritsash.setType(entity.getType());
        spiritsash.setFpCost(entity.getFpCost());
        spiritsash.setHpCost(entity.getHpCost());
        spiritsash.setEffect(entity.getEffect());
        spiritsash.setDlc(entity.getDlc());
        spiritsash.setImage(entity.getImage());
        return save(spiritsash);
    }
}
